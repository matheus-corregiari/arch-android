@file:Suppress("KotlinConstantConditions")

package br.com.arch.toolkit.android.util

import android.content.SharedPreferences
import kotlin.reflect.KClass

/**
 * Extension function to simplify [SharedPreferences] editing with automatic [SharedPreferences.Editor.apply].
 *
 * @param func A lambda executed within the context of [SharedPreferences.Editor].
 */
fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    edit().apply(func).apply()
}

/**
 * Stores a value in [SharedPreferences] using operator overloading.
 *
 * Supported types: [String], [Boolean], [Int], [Float], [Long], [Double] (stored as String), and null (removes the key).
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * @throws UnsupportedOperationException If the value type is not supported.
 */
@Throws(UnsupportedOperationException::class)
operator fun <T : Any?> SharedPreferences.set(key: String, value: T) =
    when (value) {
        null -> edit { remove(key) }

        // Primitive data types
        is String? -> edit { putString(key, value) }

        is String -> edit { putString(key, value) }

        is Boolean? -> edit { putBoolean(key, value) }

        is Boolean -> edit { putBoolean(key, value) }

        is Int? -> edit { putInt(key, value) }

        is Int -> edit { putInt(key, value) }

        is Float? -> edit { putFloat(key, value) }

        is Float -> edit { putFloat(key, value) }

        is Double? -> edit { putString(key, value.toString()) }

        is Double -> edit { putString(key, value.toString()) }

        is Long? -> edit { putLong(key, value) }

        is Long -> edit { putLong(key, value) }

        else -> throw UnsupportedOperationException("Not yet implemented: $value")
    }

/**
 * Retrieves a value from [SharedPreferences] using operator overloading.
 *
 * @param key The name of the preference to retrieve.
 * @return The value if it exists, or null otherwise.
 */
@Suppress("UNCHECKED_CAST")
operator fun <T : Any> SharedPreferences.get(key: String) = when {
    contains(key) -> all[key] as? T
    else -> null
}

internal fun <T : Any> KClass<T>.isPrimitiveForSharedPref() = when (this) {
    // Primitive data types
    String::class,
    Int::class,
    Boolean::class,
    Float::class,
    Double::class,
    Long::class -> true

    else -> false
}
