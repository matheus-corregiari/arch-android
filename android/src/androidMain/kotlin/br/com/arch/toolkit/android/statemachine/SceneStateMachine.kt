package br.com.arch.toolkit.android.statemachine

import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionManager
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Implementation of [StateMachine]
 * This implementation uses the Scene framework to make State transitions
 */
class SceneStateMachine : StateMachine<SceneStateMachine.State>() {
    override fun newStateInstance() = State()

    override fun performChangeState(state: State) {
        if (state.scene == null) return
        val scene = state.scene ?: return
        val transaction = state.transition
        val attached = scene.sceneRoot.isAttachedToWindow
        if (transaction == null || !attached) {
            scene.enter()
        } else {
            TransitionManager.go(state.scene, transaction.clone())
        }
    }

    class State internal constructor() : StateMachine.State() {

        internal var scene: Scene? = null
            private set
        internal var transition: Transition? = null
            private set

        /**
         * Sets the scene for a [SceneStateMachine.State] using a [Pair] of layout resource ID and container.
         *
         * @param pair A [Pair] containing the layout ID and the root [ViewGroup].
         * @return The [SceneStateMachine.State] instance for chaining.
         */
        fun scene(pair: Pair<Int, ViewGroup>) = scene(pair.first, pair.second)

        fun scene(@LayoutRes sceneLayout: Int, container: ViewGroup) = apply {
            scene = Scene.getSceneForLayout(container, sceneLayout, container.context)
        }

        fun scene(scene: Scene) = apply { this.scene = scene }

        fun transition(transition: Transition) = apply { this.transition = transition }

        override fun onEnter(callback: () -> Unit) = super.onEnter(callback) as State

        override fun onExit(callback: () -> Unit) = super.onExit(callback) as State
    }
}
