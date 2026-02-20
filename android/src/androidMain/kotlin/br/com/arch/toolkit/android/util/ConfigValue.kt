package br.com.arch.toolkit.android.util

import br.com.arch.toolkit.android.storage.delegate.keyValueStorage
import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage

/**
 * A wrapper class that provides a way to observe and manage a configuration value stored in [KeyValueStorage].
 *
 * It provides both [androidx.lifecycle.LiveData] and [kotlinx.coroutines.flow.Flow] for observation.
 *
 * @param T The type of the value being stored.
 * @property name The key used to store the value in the storage.
 * @property default The default value returned if no value is found in the storage.
 * @property storage A provider for the [KeyValueStorage] instance where the value is persisted.
 */
data class ConfigValue<T : Any>(
    private val name: String,
    private val default: T,
    private val storage: () -> KeyValueStorage
) {

    private var value: T? by keyValueStorage(default::class, name).storage(storage)
    private val observable = ObservableValue(default, ::value) { value = it }

    /**
     * Returns a [androidx.lifecycle.LiveData] object to observe changes to the value.
     */
    val liveData get() = observable.liveData

    /**
     * Returns a [kotlinx.coroutines.flow.Flow] to observe changes to the value.
     */
    val flow get() = observable.flow

    /**
     * Retrieves the current value.
     */
    fun get(): T = observable.value

    /**
     * Updates the value and persists it to storage.
     *
     * @param value The new value to set.
     */
    fun set(value: T) {
        observable.value = value
    }
}
