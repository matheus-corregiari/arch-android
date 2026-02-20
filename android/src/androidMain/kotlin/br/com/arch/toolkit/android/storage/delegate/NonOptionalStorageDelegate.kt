package br.com.arch.toolkit.android.storage.delegate

import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.time.Duration

/**
 * A property delegate for non-optional values in [KeyValueStorage].
 *
 * It wraps an [OptionalStorageDelegate] and provides a default value if the stored value is null.
 *
 * @param T The type of data to store.
 * @property name A lambda providing the key name.
 * @property storage A lambda providing the [KeyValueStorage] instance.
 * @property default A lambda providing the default value.
 * @property threshold The expiration duration for the memory cache.
 * @property classToParse The [KClass] of the data being stored.
 */
@ConsistentCopyVisibility
data class NonOptionalStorageDelegate<T : Any> internal constructor(
    private val name: () -> String,
    private val storage: () -> KeyValueStorage,
    private val default: () -> T,
    private val threshold: Duration,
    private val classToParse: KClass<out T>
) : StorageDelegate<T>() {

    private var savedData: T? by keyValueStorage(classToParse, name)

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = savedData
        ?: default.get().also {
            log(
                "[Storage] Delivering default value for field '${property.name}': \n\t Value -> $it"
            )
        }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        savedData = value
    }

    /**
     * Configures the [KeyValueStorage] for this delegate.
     */
    fun storage(storage: KeyValueStorage) = storage { storage }

    /**
     * Configures the [KeyValueStorage] provider for this delegate.
     */
    fun storage(storage: () -> KeyValueStorage) = copy(storage = storage)

    /**
     * Configures the expiration threshold for the memory cache.
     */
    fun threshold(threshold: Duration) = copy(threshold = threshold)
}
