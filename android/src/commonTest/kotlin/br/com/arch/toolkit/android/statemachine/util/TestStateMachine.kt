package br.com.arch.toolkit.android.statemachine.util

import br.com.arch.toolkit.android.statemachine.StateMachine

open class TestState : StateMachine.State()

class TestStateMachine : StateMachine<TestState>() {
    override fun performChangeState(state: TestState) = Unit
    override fun newStateInstance() = TestState()
}
