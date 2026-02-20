@file:Suppress("ReturnCount", "Filename")

package br.com.arch.toolkit.android.storage.delegate

import br.com.arch.toolkit.android.storage.Storage
import kotlin.reflect.KClass

/**
 * Creates an [OptionalStorageDelegate] for the specified type and name.
 *
 * @param T The type of data to store.
 * @param name The key name.
 */
inline fun <reified T : Any> keyValueStorage(name: String) = keyValueStorage(
    classToParse = T::class,
    name = { name }
)

/**
 * Creates an [OptionalStorageDelegate] for the specified type and name provider.
 *
 * @param T The type of data to store.
 * @param name A lambda providing the key name.
 */
inline fun <reified T : Any> keyValueStorage(noinline name: () -> String) = keyValueStorage(
    classToParse = T::class,
    name = name
)

/**
 * Creates an [OptionalStorageDelegate] for the specified [KClass] and name.
 *
 * @param classToParse The class of the data to store.
 * @param name The key name.
 */
fun <T : Any> keyValueStorage(classToParse: KClass<out T>, name: String) = keyValueStorage(
    classToParse = classToParse,
    name = { name }
)

/**
 * Creates an [OptionalStorageDelegate] for the specified [KClass] and name provider.
 *
 * @param classToParse The class of the data to store.
 * @param name A lambda providing the key name.
 */
fun <T : Any> keyValueStorage(classToParse: KClass<out T>, name: () -> String) =
    OptionalStorageDelegate(
        name = name,
        storage = { Storage.Settings.keyValue },
        threshold = Storage.Settings.threshold,
        classToParse = classToParse
    )
