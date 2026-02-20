package br.com.arch.toolkit.android.util

import android.content.Context
import androidx.startup.Initializer

/**
 * An [Initializer] for the toolkit's utility module, ensuring [ContextProvider] is initialized
 * with the application context.
 */
class ToolkitUtilInitialization internal constructor() : Initializer<Unit> {
    /**
     * Initializes [ContextProvider].
     *
     * @param context The application context.
     */
    override fun create(context: Context) = ContextProvider.init(context)

    /**
     * List of dependencies for this initializer.
     *
     * @return An empty list.
     */
    override fun dependencies() = mutableListOf<Class<out Initializer<*>>>()
}
