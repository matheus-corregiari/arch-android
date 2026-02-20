package br.com.arch.toolkit.android.storage

import kotlin.reflect.KClass

/**
 * Contract used by storage delegates to serialize and deserialize non-primitive values.
 *
 * Provide a platform-specific implementation (for example kotlinx.serialization or Moshi)
 * and register it through [Storage.Settings.setComplexDataParser].
 */
interface ComplexDataParser {

    /**
     * Decodes [json] into an instance of [classToParse].
     */
    fun <T : Any> fromJson(json: String, classToParse: KClass<T>): T

    /**
     * Encodes [data] as JSON.
     */
    fun <T : Any> toJson(data: T): String
}
