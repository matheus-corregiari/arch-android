package br.com.arch.toolkit.android.storage.keyValue

import br.com.arch.toolkit.android.storage.StorageType

/**
 * Generic key-value storage abstraction used across the toolkit.
 *
 * Implementations may be in-memory, SharedPreferences-based, encrypted, or custom.
 */
interface KeyValueStorage {

    /** Storage backend category. */
    val type: StorageType

    /** Unique storage name. */
    val name: String

    /** Reads a value associated with [key]. */
    operator fun <T : Any> get(key: String): T?

    /** Reads a value or returns [default] when absent. */
    operator fun <T : Any> get(key: String, default: T): T = get(key) ?: default

    /** Stores [value] under [key]. */
    operator fun <T : Any> set(key: String, value: T?)

    /** Removes a single key. */
    fun remove(key: String)

    /** Removes every key that matches [regex]. */
    fun remove(regex: Regex) = keys().filter { it.matches(regex) }.forEach { remove(it) }

    /** Removes every entry. */
    fun clear()

    /** Returns `true` when [key] exists. */
    fun contains(key: String): Boolean

    /** Total number of stored entries. */
    fun size(): Int

    /** Snapshot of all keys currently stored. */
    fun keys(): List<String>
}
