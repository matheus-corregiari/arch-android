package br.com.arch.toolkit.android.storage.delegate

import android.util.Log
import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage

internal fun (() -> String).get() = runCatching { invoke().takeIf { it.isNotBlank() } }
    .onFailure {
        Log.e("Storage Delegate", "[Storage] Failed to get name for key value storage", it)
    }.getOrNull()

internal fun (() -> KeyValueStorage).get() = runCatching { invoke() }.onFailure {
    Log.e("Storage Delegate", "[Storage] Failed to get storage for key value storage", it)
}.getOrNull()

internal fun <T : Any> (() -> T).get() = runCatching { invoke() }.onFailure {
    Log.e("Storage Delegate", "[Storage] Failed to get default for key value storage", it)
}.getOrThrow()

/**
 * Base class for storage delegates providing logging utilities.
 *
 * @param T The type of data handled by the delegate.
 */
sealed class StorageDelegate<T : Any> {

    /**
     * Logs an error with the "Storage Delegate" tag.
     */
    protected fun Throwable.log(message: String) {
        Log.e("Storage Delegate", message, this)
    }

    /**
     * Logs an info message with the "Storage Delegate" tag.
     */
    protected fun log(message: String) {
        Log.i("Storage Delegate", message)
    }
}
