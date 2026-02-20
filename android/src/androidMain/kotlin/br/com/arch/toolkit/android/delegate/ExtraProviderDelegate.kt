package br.com.arch.toolkit.android.delegate

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.reflect.KProperty

/**
 * A property delegate for retrieving and optionally caching extras from [AppCompatActivity] intents
 * or [Fragment] arguments.
 *
 * It also supports retrieving values from URI query parameters if the type is [String].
 *
 * @param T The type of the extra.
 * @property extraName The key used to find the extra.
 * @property keepState If true, the retrieved value is cached in the delegate.
 * @property type The source type for the extra ([ExtraType]).
 * @property defaultValue A lambda providing a default value if the extra is not found.
 */
class ExtraProviderDelegate<T>(
    private val extraName: String,
    private val keepState: Boolean,
    private val type: ExtraType,
    private val defaultValue: () -> T
) {

    private var extra: T? = null

    operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        val newExtra = when (type) {
            ExtraType.ARGUMENT -> getExtra(extra, extraName, thisRef) ?: defaultValue.invoke()
            ExtraType.QUERY -> getQueryParameter(extra, extraName, thisRef) ?: defaultValue.invoke()
            ExtraType.AUTO -> getExtra(extra, extraName, thisRef)
                ?: (if (extra is String?) getQueryParameter(extra, extraName, thisRef) else null)
                ?: defaultValue.invoke()
        }

        if (keepState) {
            extra = newExtra
        }

        return newExtra
    }

    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val newExtra = when (type) {
            ExtraType.ARGUMENT -> getExtra(extra, extraName, thisRef) ?: defaultValue.invoke()
            ExtraType.QUERY -> getQueryParameter(extra, extraName, thisRef) ?: defaultValue.invoke()
            ExtraType.AUTO -> getExtra(extra, extraName, thisRef)
                ?: (if (extra is String?) getQueryParameter(extra, extraName, thisRef) else null)
                ?: (thisRef.activity as? AppCompatActivity)?.let { getExtra(extra, extraName, it) }
                ?: defaultValue.invoke()
        }

        if (keepState) {
            extra = newExtra
        }

        return newExtra
    }

    operator fun setValue(thisRef: AppCompatActivity, property: KProperty<*>, value: T) {
        extra = value
    }

    operator fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        extra = value
    }

    //region AppCompatActivity methods
    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    private fun <T> getExtra(oldExtra: T?, extraName: String, thisRef: AppCompatActivity): T? =
        oldExtra ?: thisRef.intent?.extras?.get(extraName) as T?

    @Suppress("UNCHECKED_CAST")
    private fun getQueryParameter(oldExtra: T?, extraName: String, thisRef: AppCompatActivity): T? {
        val isStringType = oldExtra is String?
        if (isStringType) {
            return oldExtra ?: thisRef.intent?.data?.getQueryParameter(extraName) as T?
        } else {
            error("Query parameters can only be used with String type parameters")
        }
    }
    //endregion

    //region Fragment methods
    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    private fun <T> getExtra(oldExtra: T?, extraName: String, thisRef: Fragment): T? =
        oldExtra ?: thisRef.arguments?.get(extraName) as T?

    @Suppress("UNCHECKED_CAST")
    private fun getQueryParameter(oldExtra: T?, extraName: String, thisRef: Fragment): T? {
        val isStringType = oldExtra is String?
        if (isStringType) {
            return oldExtra ?: thisRef.activity?.intent?.data?.getQueryParameter(extraName) as T?
        } else {
            error("Query parameters can only be used with String type parameters")
        }
    }
    //endregion
}

/**
 * Defines the source of the extra.
 */
enum class ExtraType {
    /**
     * Look into Intent extras or Fragment arguments.
     */
    ARGUMENT,

    /**
     * Look into URI query parameters (String only).
     */
    QUERY,

    /**
     * Look into both Intent extras and URI query parameters.
     */
    AUTO
}

/**
 * Creates an [ExtraProviderDelegate] for an optional extra.
 */
fun <T> extraProvider(extra: String) = extraProvider<T?>(extra, true)

/**
 * Creates an [ExtraProviderDelegate] for an optional extra with state keeping configuration.
 */
fun <T> extraProvider(extra: String, keepState: Boolean) = extraProvider<T?>(extra, keepState, null)

/**
 * Creates an [ExtraProviderDelegate] with a default value.
 */
fun <T> extraProvider(extra: String, default: T) = extraProvider(extra, true, default)

/**
 * Creates an [ExtraProviderDelegate] with state keeping and a default value.
 */
fun <T> extraProvider(extra: String, keepState: Boolean, default: T) =
    extraProvider(extra, keepState, ExtraType.AUTO) { default }

/**
 * Creates an [ExtraProviderDelegate] with a specific [ExtraType].
 */
fun <T> extraProvider(extra: String, type: ExtraType) = extraProvider<T?>(extra, true, type)

/**
 * Creates an [ExtraProviderDelegate] with state keeping and a specific [ExtraType].
 */
fun <T> extraProvider(extra: String, keepState: Boolean, type: ExtraType) =
    extraProvider<T?>(extra, keepState, type, null)

/**
 * Creates an [ExtraProviderDelegate] with a specific [ExtraType] and default value.
 */
fun <T> extraProvider(extra: String, type: ExtraType, default: T) =
    extraProvider(extra, true, type, default)

/**
 * Creates an [ExtraProviderDelegate] with state keeping, specific [ExtraType] and default value.
 */
fun <T> extraProvider(extra: String, keepState: Boolean, type: ExtraType, default: T) =
    extraProvider(extra, keepState, type) { default }

/**
 * Creates an [ExtraProviderDelegate] with state keeping, specific [ExtraType] and a default value provider.
 */
fun <T> extraProvider(extra: String, keepState: Boolean, type: ExtraType, default: () -> T) =
    ExtraProviderDelegate(extra, keepState, type, default)
