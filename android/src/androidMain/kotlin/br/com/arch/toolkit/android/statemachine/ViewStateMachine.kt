@file:Suppress("unused", "SpellCheckingInspection")

package br.com.arch.toolkit.android.statemachine

import android.view.View
import android.view.ViewStub
import androidx.annotation.IdRes

/**
 * Implementation of [StateMachine]
 * This implementation uses View Visibility to make State transitions
 */
class ViewStateMachine : StateMachine<ViewStateMachine.State>() {

    override fun newStateInstance() = State()

    override fun performChangeState(state: State) {
        handleVisibility(state)
        handleEnable(state)
    }

    @Suppress("CyclomaticComplexMethod")
    private fun handleVisibility(state: State) {
        for (view in state.goneViews) {
            if (view == null) continue
            view.visibility = View.GONE
        }

        for (view in state.visibles) {
            if (view == null) continue
            view.visibility = View.VISIBLE
        }

        for (view in state.invisibleViews) {
            if (view == null) continue
            view.visibility = View.INVISIBLE
        }

        // Handle view references
        val rootView = state.rootView ?: return

        for (@IdRes viewId in state.goneReferences) {
            val view = rootView.findViewById<View?>(viewId) ?: continue
            view.visibility = View.GONE
        }
        for (@IdRes viewId in state.visibleReferences) {
            val view = rootView.findViewById<View?>(viewId) ?: continue
            if (view is ViewStub) view.inflate()
            view.visibility = View.VISIBLE
        }
        for (@IdRes viewId in state.invisibleReferences) {
            val view = rootView.findViewById<View?>(viewId) ?: continue
            view.visibility = View.INVISIBLE
        }
    }

    private fun handleEnable(state: State) {
        // Enable
        for (view in state.enables) {
            if (view == null) continue
            view.setEnabled(true)
        }

        for (view in state.disables) {
            if (view == null) continue
            view.setEnabled(false)
        }

        // Handle view references
        val rootView = state.rootView ?: return

        for (@IdRes viewId in state.enableReferences) {
            val view = rootView.findViewById<View?>(viewId) ?: continue
            view.setEnabled(true)
        }

        for (@IdRes viewId in state.disableReferences) {
            val view = rootView.findViewById<View?>(viewId) ?: continue
            view.setEnabled(false)
        }
    }

    /**
     * Represents a single state in a [ViewStateMachine].
     */
    @Suppress("TooManyFunctions")
    class State internal constructor() : StateMachine.State() {

        private val mutableVisibles = mutableSetOf<View?>()
        internal val visibles: Set<View?> get() = mutableVisibles.toSet()
        private val mutableVisibleReferences = mutableSetOf<Int>()
        internal val visibleReferences: Set<Int> get() = mutableVisibleReferences.toSet()

        private val mutableGoneViews = mutableSetOf<View?>()
        internal val goneViews: Set<View?> get() = mutableGoneViews.toSet()
        private val mutableGoneReferences = mutableSetOf<Int>()
        internal val goneReferences: Set<Int> get() = mutableGoneReferences.toSet()

        private val mutableInvisibleViews = mutableSetOf<View?>()
        internal val invisibleViews: Set<View?> get() = mutableInvisibleViews.toSet()
        private val mutableInvisibleReferences = mutableSetOf<Int>()
        internal val invisibleReferences: Set<Int> get() = mutableInvisibleReferences.toSet()

        private val mutableEnables = mutableSetOf<View?>()
        internal val enables: Set<View?> get() = mutableEnables.toSet()
        private val mutableEnableReferences = mutableSetOf<Int>()
        internal val enableReferences: Set<Int> get() = mutableEnableReferences.toSet()

        private val mutableDisables = mutableSetOf<View?>()
        internal val disables: Set<View?> get() = mutableDisables.toSet()
        private val mutableDisableReferences = mutableSetOf<Int>()
        internal val disableReferences: Set<Int> get() = mutableDisableReferences.toSet()

        internal var rootView: View? = null
            private set

        /**
         * Sets the root view to be used for finding views by ID.
         *
         * @param view The root view.
         * @return The state instance for chaining.
         */
        fun root(view: View) = apply { rootView = view }

        /**
         * Sets the views to be made visible when this state is entered.
         *
         * @param views The views to make visible.
         * @return The state instance for chaining.
         */
        fun visibles(vararg views: View?) = apply { mutableVisibles.addAll(views) }

        /**
         * Sets the view IDs to be made visible when this state is entered.
         *
         * @param ids The view IDs to make visible.
         * @return The state instance for chaining.
         */
        fun visibles(@IdRes vararg ids: Int) =
            apply { mutableVisibleReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be made invisible when this state is entered.
         *
         * @param views The views to make invisible.
         * @return The state instance for chaining.
         */
        fun invisibles(vararg views: View?) = apply { mutableInvisibleViews.addAll(views) }

        /**
         * Sets the view IDs to be made invisible when this state is entered.
         *
         * @param ids The view IDs to make invisible.
         * @return The state instance for chaining.
         */
        fun invisibles(@IdRes vararg ids: Int) =
            apply { mutableInvisibleReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be made gone when this state is entered.
         *
         * @param views The views to make gone.
         * @return The state instance for chaining.
         */
        fun gones(vararg views: View?) = apply { mutableGoneViews.addAll(views) }

        /**
         * Sets the view IDs to be made gone when this state is entered.
         *
         * @param ids The view IDs to make gone.
         * @return The state instance for chaining.
         */
        fun gones(@IdRes vararg ids: Int) = apply { mutableGoneReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be enabled when this state is entered.
         *
         * @param views The views to enable.
         * @return The state instance for chaining.
         */
        fun enables(vararg views: View?) = apply { mutableEnables.addAll(views) }

        /**
         * Sets the view IDs to be enabled when this state is entered.
         *
         * @param ids The view IDs to enable.
         * @return The state instance for chaining.
         */
        fun enables(@IdRes vararg ids: Int) = apply { mutableEnableReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be disabled when this state is entered.
         *
         * @param views The views to disable.
         * @return The state instance for chaining.
         */
        fun disables(vararg views: View?) = apply { mutableDisables.addAll(views) }

        /**
         * Sets the view IDs to be disabled when this state is entered.
         *
         * @param ids The view IDs to disable.
         * @return The state instance for chaining.
         */
        fun disables(@IdRes vararg ids: Int) =
            apply { mutableDisableReferences.addAll(ids.toSet()) }

        override fun onEnter(callback: () -> Unit) = super.onEnter(callback) as State
        override fun onExit(callback: () -> Unit) = super.onExit(callback) as State
    }
}
