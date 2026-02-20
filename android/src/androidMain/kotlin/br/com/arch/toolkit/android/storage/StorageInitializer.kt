package br.com.arch.toolkit.android.storage

import android.content.Context
import androidx.startup.Initializer

/**
 * An [Initializer] for the storage system, ensuring [Storage.KeyValue] is initialized
 * before use.
 */
class StorageInitializer internal constructor() : Initializer<Unit> {
    /**
     * Initializes [Storage.KeyValue].
     *
     * @param context The application context.
     */
    override fun create(context: Context) = Storage.KeyValue.init(context)

    /**
     * List of dependencies for this initializer.
     *
     * @return An empty list.
     */
    override fun dependencies() = mutableListOf<Class<out Initializer<*>>>()
}
