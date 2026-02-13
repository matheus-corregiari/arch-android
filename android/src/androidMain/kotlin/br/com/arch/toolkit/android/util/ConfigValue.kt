package br.com.arch.toolkit.android.util

import br.com.arch.toolkit.android.storage.delegate.keyValueStorage
import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage

data class ConfigValue<T : Any>(
    private val name: String,
    private val default: T,
    private val storage: () -> KeyValueStorage
) {

    private var _value: T? by keyValueStorage(default::class, name).storage(storage)
    private val observable = ObservableValue(default, ::_value) { _value = it }

    val liveData get() = observable.liveData
    val flow get() = observable.flow

    fun get(): T = observable.value
    fun set(value: T) {
        observable.value = value
    }
}
