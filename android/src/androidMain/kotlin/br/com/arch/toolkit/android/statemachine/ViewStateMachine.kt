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

        internal val visibles: Set<View?> field = mutableSetOf()
        internal val visibleReferences: Set<Int> field = mutableSetOf()

        internal val goneViews: Set<View?> field = mutableSetOf()
        internal val goneReferences: Set<Int> field = mutableSetOf()

        internal val invisibleViews: Set<View?> field = mutableSetOf()
        internal val invisibleReferences: Set<Int> field = mutableSetOf()

        internal val enables: Set<View?> field = mutableSetOf()
        internal val enableReferences: Set<Int> field = mutableSetOf()

        internal val disables: Set<View?> field = mutableSetOf()
        internal val disableReferences: Set<Int> field = mutableSetOf()

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
        fun visibles(vararg views: View?) = apply { visibles.addAll(views) }

        /**
         * Sets the view IDs to be made visible when this state is entered.
         *
         * @param ids The view IDs to make visible.
         * @return The state instance for chaining.
         */
        fun visibles(@IdRes vararg ids: Int) = apply { visibleReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be made invisible when this state is entered.
         *
         * @param views The views to make invisible.
         * @return The state instance for chaining.
         */
        fun invisibles(vararg views: View?) = apply { invisibleViews.addAll(views) }

        /**
         * Sets the view IDs to be made invisible when this state is entered.
         *
         * @param ids The view IDs to make invisible.
         * @return The state instance for chaining.
         */
        fun invisibles(@IdRes vararg ids: Int) = apply { invisibleReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be made gone when this state is entered.
         *
         * @param views The views to make gone.
         * @return The state instance for chaining.
         */
        fun gones(vararg views: View?) = apply { goneViews.addAll(views) }

        /**
         * Sets the view IDs to be made gone when this state is entered.
         *
         * @param ids The view IDs to make gone.
         * @return The state instance for chaining.
         */
        fun gones(@IdRes vararg ids: Int) = apply { goneReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be enabled when this state is entered.
         *
         * @param views The views to enable.
         * @return The state instance for chaining.
         */
        fun enables(vararg views: View?) = apply { enables.addAll(views) }

        /**
         * Sets the view IDs to be enabled when this state is entered.
         *
         * @param ids The view IDs to enable.
         * @return The state instance for chaining.
         */
        fun enables(@IdRes vararg ids: Int) = apply { enableReferences.addAll(ids.toSet()) }

        /**
         * Sets the views to be disabled when this state is entered.
         *
         * @param views The views to disable.
         * @return The state instance for chaining.
         */
        fun disables(vararg views: View?) = apply { disables.addAll(views) }

        /**
         * Sets the view IDs to be disabled when this state is entered.
         *
         * @param ids The view IDs to disable.
         * @return The state instance for chaining.
         */
        fun disables(@IdRes vararg ids: Int) = apply { disableReferences.addAll(ids.toSet()) }

        override fun onEnter(callback: () -> Unit) = super.onEnter(callback) as State
        override fun onExit(callback: () -> Unit) = super.onExit(callback) as State
    }
}
