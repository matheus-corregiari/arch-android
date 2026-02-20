package br.com.arch.toolkit.android.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update

/**
 * Observable wrapper for a value persisted by external getter/setter functions.
 *
 * The internal state is mirrored in a [Flow] and [LiveData], allowing Kotlin-first APIs that are
 * still interoperable with Android Lifecycle observers.
 *
 * @param initialValue fallback value used before reading from [getter].
 * @param getter source of truth reader.
 * @param setter source of truth writer. When null, [value] becomes read-only.
 */
class ObservableValue<T>(
    initialValue: T,
    private val getter: () -> T?,
    private val setter: ((T?) -> Unit)? = null
) {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(job + Dispatchers.IO)
    private val _flow = MutableStateFlow(initialValue)

    /**
     * Cold observable value stream.
     *
     * Every access synchronizes from [getter] before returning.
     */
    val flow: Flow<T>
        get() {
            updateWithGetter()
            return _flow.asStateFlow().shareIn(scope, SharingStarted.WhileSubscribed())
        }

    /**
     * [LiveData] view of [flow], useful for lifecycle-aware Android observers.
     */
    val liveData: LiveData<T>
        get() {
            updateWithGetter()
            return _flow.asStateFlow().asLiveData(scope.coroutineContext)
        }

    /**
     * Current value synchronized with [getter].
     *
     * Write operations call [setter] (if available) and then update the local cache.
     */
    var value: T
        get() = updateWithGetter() ?: _flow.value
        set(value) {
            setter ?: return
            if (_flow.value != value) {
                runCatching { setter?.invoke(value) }
                _flow.update { value }
            }
        }

    private fun updateWithGetter() = runCatching { getter.invoke() }.getOrNull()
        ?.also { saved -> if (_flow.value != saved) _flow.update { saved } }
}
