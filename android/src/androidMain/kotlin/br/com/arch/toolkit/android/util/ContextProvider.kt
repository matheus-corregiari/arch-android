package br.com.arch.toolkit.android.util

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Context
import android.os.Bundle
import java.lang.ref.WeakReference

/**
 * Lightweight global [Context] accessor backed by [WeakReference].
 *
 * The latest created/resumed [Activity] is preferred, with [Application] as fallback.
 * Because references are weak, consumers should not cache [current] strongly for long periods.
 */
object ContextProvider {

    private var lastContext: WeakReference<Context>? = null
    private val callback = object : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            lastContext = WeakReference(activity)
        }

        override fun onActivityResumed(activity: Activity) {
            lastContext = WeakReference(activity)
        }

        override fun onActivityStarted(activity: Activity) = Unit
        override fun onActivityPaused(activity: Activity) = Unit
        override fun onActivityStopped(activity: Activity) = Unit
        override fun onActivitySaveInstanceState(
            activity: Activity,
            outState: Bundle
        ) = Unit

        override fun onActivityDestroyed(activity: Activity) = Unit
    }

    /** Last available [Context], or `null` if it has been garbage collected. */
    val current: Context? get() = lastContext?.get()

    /**
     * Initializes the provider with any Android [Context].
     *
     * If possible, lifecycle callbacks are registered to keep [current] updated.
     */
    fun init(context: Context) {
        lastContext = WeakReference(context)
        (context as? Application)?.let(::register)
            ?: (context.applicationContext as? Application)?.let(::register)
    }

    /**
     * Registers activity lifecycle callbacks in [application] to keep [current] up to date.
     */
    fun register(application: Application) {
        if (current == null) lastContext = WeakReference(application)
        application.registerActivityLifecycleCallbacks(callback)
    }
}
