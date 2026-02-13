package br.com.arch.toolkit.android.statemachine

import android.view.ViewGroup

/**
 * Change the Scene configuration of the state
 */
fun SceneStateMachine.State.scene(pair: Pair<Int, ViewGroup>) =
    scene(pair.first, pair.second)
