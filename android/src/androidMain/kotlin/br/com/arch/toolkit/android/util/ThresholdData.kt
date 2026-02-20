package br.com.arch.toolkit.android.util

import kotlin.time.Duration

/**
 * Keeps a single value in memory and automatically invalidates it after [duration].
 *
 * The cache entry is scoped by both `storageName` and `name`. A `get` call with a different
 * scope clears the entry and returns `null`.
 *
 * This utility is platform-agnostic and can be reused from KMP shared logic.
 */
class ThresholdData<T>(private val duration: Duration) {

    private var storageName: String? = null
    private var data: T? = null
    private var name: String? = null
    private var timestamp: Long? = null

    /**
     * Returns `true` when the cached value is missing or older than [duration].
     */
    fun isExpired(): Boolean {
        this.storageName ?: return true
        this.data ?: return true
        this.name ?: return true
        val lastTimestamp = this.timestamp ?: return true
        val deltaTime = System.currentTimeMillis() - lastTimestamp

        return deltaTime > duration.inWholeMilliseconds
    }

    /**
     * Returns the cached value for the informed scope.
     *
     * If the entry is expired or the scope does not match, this cache is cleared and `null`
     * is returned.
     */
    fun get(storageName: String, name: String): T? = when {
        isExpired() -> run {
            clear()
            null
        }
        storageName != this.storageName -> run {
            clear()
            null
        }
        name != this.name -> run {
            clear()
            null
        }
        else -> this.data.ifNull { clear() }
    }

    /**
     * Replaces the current entry.
     *
     * Passing `null` clears this cache.
     */
    fun set(storageName: String, name: String, data: T?) {
        clear()
        if (data == null) return

        this.storageName = storageName
        this.data = data
        this.name = name
        this.timestamp = System.currentTimeMillis()
    }

    /** Clears all cached metadata and value. */
    fun clear() {
        this.storageName = null
        this.data = null
        this.name = null
        this.timestamp = null
    }

    private fun <T> T?.ifNull(block: () -> Unit) = apply { if (this == null) block() }
}
