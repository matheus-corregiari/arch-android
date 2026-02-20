package br.com.arch.toolkit.android.storage.delegate

import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage
import br.com.arch.toolkit.lumber.Lumber

internal fun (() -> String).get() = runCatching { invoke().takeIf { it.isNotBlank() } }
    .onFailure {
        Lumber.tag(
            "Storage Delegate"
        ).error(it, "[Storage] Failed to get name for key value storage")
    }.getOrNull()

internal fun (() -> KeyValueStorage).get() = runCatching { invoke() }.onFailure {
    Lumber.tag(
        "Storage Delegate"
    ).error(it, "[Storage] Failed to get storage for key value storage")
}.getOrNull()

internal fun <T : Any> (() -> T).get() = runCatching { invoke() }.onFailure {
    Lumber.tag(
        "Storage Delegate"
    ).error(it, "[Storage] Failed to get default for key value storage")
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
        Lumber.tag("Storage Delegate").error(this, message)
    }

    /**
     * Logs an info message with the "Storage Delegate" tag.
     */
    protected fun log(message: String) {
        Lumber.tag("Storage Delegate").info(message)
    }
}
