@file:Suppress("TooManyFunctions")

package br.com.arch.toolkit.android.statemachine

import android.os.Bundle
import androidx.core.os.bundleOf

abstract class StateMachine<STATE : StateMachine.State> {

    private companion object {
        const val STATE_MACHINE_CURRENT_KEY: String = "STATE_MACHINE_CURRENT_KEY"
    }

    /**
     * Current state key of the machine.
     */
    private var currentStateKey = -1

    /**
     * Map of state keys to their respective state configurations.
     */
    private val stateMap = mutableMapOf<Int, STATE>()

    /**
     * The configuration for this state machine.
     */
    val config = Config()

    /**
     * Indicates whether the machine has been started.
     */
    var isStarted = false
        private set

    /**
     * Performs the actual transition to the new state.
     *
     * @param state The state to become active.
     */
    protected abstract fun performChangeState(state: STATE)

    /**
     * Creates a new instance of the specific state type.
     *
     * @return A new instance of `STATE`.
     */
    abstract fun newStateInstance(): STATE

    /**
     * Returns the key of the current state.
     *
     * @return The current state key, or the initial state key if no transition has occurred.
     */
    fun getCurrentStateKey() = if (currentStateKey == -1) config.initialState else currentStateKey

    /**
     * Starts the state machine. This must be called after all states are added and initial configuration is set.
     *
     * @throws IllegalStateException If the machine is already started or if the initial state is not found.
     */
    fun start() {
        check(!isStarted) { "Machine already started" }

        isStarted = true

        if (getCurrentStateKey() <= -1) return

        val state = stateMap[getCurrentStateKey()]
        checkNotNull(state) {
            "State not found! Make sure to add all states before starting the machine."
        }
        changeState(getCurrentStateKey(), true)
    }

    /**
     * Shuts down the state machine, clearing states and resetting configuration.
     */
    fun shutdown() {
        stateMap.clear()
        isStarted = false
        currentStateKey = -1
        config.reset()
    }

    /**
     * Changes the current state of the machine.
     *
     * @param stateKey      The key of the state to become active.
     * @param forceChange   If `true`, transitions even if `stateKey` is the current state.
     * @param onChangeState Optional callback to be invoked before the state change.
     * @throws IllegalStateException If the machine is not started or the state key is not found.
     */
    fun changeState(
        stateKey: Int,
        forceChange: Boolean = false,
        onChangeState: ((Int) -> Unit)? = config.onChangeState
    ) {
        check(isStarted) { "Call StateMachine#start() before making any state changes." }

        if (stateKey == getCurrentStateKey() && !forceChange) return

        val state = stateMap[stateKey]
        checkNotNull(state) { "State $stateKey does not exist!" }

        onChangeState?.invoke(stateKey)

        val currentState = stateMap[getCurrentStateKey()]
        if (stateKey != getCurrentStateKey() && currentState != null) currentState.exit?.invoke()
        performChangeState(state)
        state.enter?.invoke()
        currentStateKey = stateKey
    }

    /**
     * Adds a new state to the machine.
     *
     * @param key   The unique key for the state. Must be >= 0.
     * @param state The state configuration.
     * @return The state machine instance for chaining.
     * @throws IllegalStateException If the machine is already started or the key is negative.
     */
    fun addState(key: Int, state: STATE) = apply {
        check(!isStarted) { "Machine already started" }
        check(key >= 0) { "State Keys must be >= 0" }

        stateMap[key] = state
    }

    /**
     * Configures and starts the [StateMachine].
     *
     * @param func A lambda to configure the state machine.
     */
    inline fun setup(func: StateMachine<STATE>.() -> Unit) {
        apply(func)
        start()
    }

    /**
     * Provides a DSL-like way to configure the [StateMachine.Config].
     *
     * @param configuration A lambda to apply configurations.
     */
    inline fun config(configuration: Config.() -> Unit) = config.run(configuration)

    /**
     * Adds a new state to the [StateMachine] using a DSL-like syntax.
     *
     * @param key The unique key for the state.
     * @param stateConfig A lambda to configure the new state instance.
     * @throws IllegalStateException If the machine is already started or the key is negative.
     * @see [StateMachine.addState]
     */
    inline fun state(key: Int, stateConfig: STATE.() -> Unit) =
        addState(key, newStateInstance().apply(stateConfig))

    /**
     * Restores the state of the machine from a [Bundle].
     *
     * @param savedInstanceState The bundle containing the saved state.
     * @return The state machine instance for chaining.
     * @throws IllegalStateException If the machine is already started.
     */
    fun restoreInstanceState(savedInstanceState: Bundle?): StateMachine<STATE> {
        check(!isStarted) { "Machine already started" }
        if (savedInstanceState == null) return this
        currentStateKey = savedInstanceState.getInt(STATE_MACHINE_CURRENT_KEY, getCurrentStateKey())
        return this
    }

    /**
     * Saves the current state of the machine into a [Bundle].
     *
     * @return A [Bundle] containing the current state key.
     */
    fun saveInstanceState() = bundleOf(STATE_MACHINE_CURRENT_KEY to getCurrentStateKey())

    /**
     * Configuration for the [StateMachine].
     */
    class Config internal constructor() {
        var initialState = -1
            private set

        /**
         * Sets the global state change callback.
         *
         * @param onChangeState The callback to be invoked on state changes.
         */
        var onChangeState: ((Int) -> Unit)? = null
            private set

        /**
         * Sets the initial state key.
         *
         * @param initialState The key for the initial state.
         * @throws IllegalStateException If the key is negative.
         */
        fun setInitialState(initialState: Int) = apply {
            check(initialState >= 0) { "initialState cannot be < 0" }
            this.initialState = initialState
        }

        fun setOnChangeState(onChangeState: (Int) -> Unit) = apply {
            this.onChangeState = onChangeState
        }

        internal fun reset() = apply {
            initialState = -1
            onChangeState = null
        }
    }

    /**
     * Represents a single state in the state machine.
     */
    abstract class State {
        var enter: (() -> Unit)? = null
            private set
        var exit: (() -> Unit)? = null
            private set

        /**
         * Sets a callback to be invoked when entering this state.
         *
         * @param callback The callback instance.
         * @return The state instance for chaining.
         */
        open fun onEnter(callback: () -> Unit) = apply { enter = callback }

        /**
         * Sets a callback to be invoked when exiting this state.
         *
         * @param callback The callback instance.
         * @return The state instance for chaining.
         */
        open fun onExit(callback: () -> Unit) = apply { exit = callback }
    }
}
