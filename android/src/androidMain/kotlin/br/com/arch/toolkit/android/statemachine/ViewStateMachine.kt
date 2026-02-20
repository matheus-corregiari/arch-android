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

        fun root(view: View) = apply { rootView = view }

        fun visibles(vararg views: View?) = apply { visibles.addAll(views) }

        fun visibles(@IdRes vararg ids: Int) = apply { visibleReferences.addAll(ids.toSet()) }

        fun invisibles(vararg views: View?) = apply { invisibleViews.addAll(views) }

        fun invisibles(@IdRes vararg ids: Int) = apply { invisibleReferences.addAll(ids.toSet()) }

        fun gones(vararg views: View?) = apply { goneViews.addAll(views) }

        fun gones(@IdRes vararg ids: Int) = apply { goneReferences.addAll(ids.toSet()) }

        fun enables(vararg views: View?) = apply { enables.addAll(views) }

        fun enables(@IdRes vararg ids: Int) = apply { enableReferences.addAll(ids.toSet()) }

        fun disables(vararg views: View?) = apply { disables.addAll(views) }

        fun disables(@IdRes vararg ids: Int) = apply { disableReferences.addAll(ids.toSet()) }

        override fun onEnter(callback: () -> Unit) = super.onEnter(callback) as State
        override fun onExit(callback: () -> Unit) = super.onExit(callback) as State
    }
}
