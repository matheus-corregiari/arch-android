package br.com.arch.toolkit.android.storage.delegate

import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage

internal fun (() -> String).get() = runCatching { invoke().takeIf { it.isNotBlank() } }.getOrNull()

internal fun (() -> KeyValueStorage).get() = runCatching { invoke() }.getOrNull()

internal fun <T : Any> (() -> T).get() = invoke()

/**
 * Base type for storage delegates.
 *
 * @param T The type of data handled by the delegate.
 */
sealed class StorageDelegate<T : Any>
