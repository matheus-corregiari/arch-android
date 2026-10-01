@file:Suppress("DEPRECATION")

package br.com.arch.toolkit.android.storage.keyValue

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import br.com.arch.toolkit.android.storage.StorageType
import br.com.arch.toolkit.android.util.edit
import br.com.arch.toolkit.android.util.get
import br.com.arch.toolkit.android.util.set

/**
 * An implementation of [KeyValueStorage] that uses [SharedPreferences] for persistence.
 *
 * It includes a memory cache ([MemoryStorage]) for faster access and is thread-safe.
 *
 * @property type The type of storage ([StorageType.SHARED_PREF] or [StorageType.ENCRYPTED_SHARED_PREF]).
 * @property sharedPref The underlying [SharedPreferences] instance.
 */
sealed class SharedPrefStorage(
    override val type: StorageType,
    private val sharedPref: SharedPreferences
) : KeyValueStorage {

    private val lock = Any()
    private val mirageStorage: KeyValueStorage by lazy { MemoryStorage(name) }

    /**
     * A regular, non-encrypted [SharedPrefStorage].
     *
     * @param context The application context.
     * @param name The name of the SharedPreferences file.
     */
    class Regular(context: Context, override val name: String) : SharedPrefStorage(
        StorageType.SHARED_PREF,
        context.getSharedPreferences(name, Context.MODE_PRIVATE)
    )

    /**
     * An encrypted [SharedPrefStorage] using [EncryptedSharedPreferences].
     *
     * @param context The application context.
     * @param name The name of the SharedPreferences file.
     */
    class Encrypted(context: Context, override val name: String) : SharedPrefStorage(
        StorageType.ENCRYPTED_SHARED_PREF,
        EncryptedSharedPreferences.create(
            name,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    )

    override fun <T : Any> get(key: String): T? = synchronized(lock) {
        mirageStorage[key] ?: sharedPref.get<T>(key).also { mirageStorage[key] = it }
    }

    override fun <T : Any> set(key: String, value: T?) = when {
        /* Validate Value */
        value == null -> remove(key)
        value == null.toString() -> remove(key)
        (value as? String)?.isBlank() == true -> remove(key)

        /* Validate Key */
        key.isBlank() -> remove(key)
        key == null.toString() -> remove(key)

        /* If reaches here, the Key and the Value are good to go! */
        else -> synchronized(lock) {
            sharedPref[key] = value
            mirageStorage[key] = value
        }
    }

    override fun remove(key: String) = synchronized(lock) {
        if (contains(key)) {
            sharedPref.edit { remove(key) }
        }
        mirageStorage.remove(key)
    }

    override fun clear() = synchronized(lock) {
        sharedPref.edit { clear() }
        mirageStorage.clear()
    }

    override fun contains(key: String): Boolean = run { sharedPref.contains(key) }

    override fun size(): Int = sharedPref.all.count()

    override fun keys(): List<String> = sharedPref.all.keys.toList()
}
