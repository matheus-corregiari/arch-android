package br.com.arch.toolkit.android.storage.keyValue

import br.com.arch.toolkit.android.storage.StorageType
import kotlin.collections.set

/**
 * An in-memory implementation of [KeyValueStorage].
 *
 * This storage is volatile and will be cleared when the application process is killed.
 * It is thread-safe.
 *
 * @property name The identifier for this storage instance.
 */
class MemoryStorage internal constructor(override val name: String) : KeyValueStorage {

    override val type: StorageType = StorageType.MEMORY
    private val lock = Any()
    private val map: MutableMap<String, Any> = mutableMapOf()

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> get(key: String): T? = synchronized(lock) { map[key] as? T? }

    override fun <T : Any> set(key: String, value: T?) = when {
        /* Validate Value */
        value == null -> remove(key)
        value == null.toString() -> remove(key)
        (value as? String)?.isBlank() == true -> remove(key)

        /* Validate Key */
        key.isBlank() -> remove(key)
        key == null.toString() -> remove(key)

        /* If reaches here, the Key and the Value are good to go! */
        else -> synchronized(lock) { map[key] = value }
    }

    override fun remove(key: String) = synchronized(lock) { if (contains(key)) map.remove(key) }

    override fun clear() = synchronized(lock) { map.clear() }

    override fun contains(key: String): Boolean = map.containsKey(key)

    override fun size(): Int = map.count()

    override fun keys(): List<String> = map.keys.toList()
}
