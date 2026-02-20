//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)

# StateMachine

abstract class [StateMachine](index.md)&lt;[STATE](index.md) : [StateMachine.State](-state/index.md)&gt;

A generic state machine for managing application or view states.

#### Parameters

android

| | |
|---|---|
| STATE | The type of state handled by this machine, must extend [StateMachine.State](-state/index.md). |

#### Inheritors

| |
|---|
| [SceneStateMachine](../-scene-state-machine/index.md) |
| [ViewStateMachine](../-view-state-machine/index.md) |

## Constructors

| | |
|---|---|
| [StateMachine](-state-machine.md) | [android]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Config](-config/index.md) | [android]<br>class [Config](-config/index.md)<br>Configuration for the [StateMachine](index.md). |
| [State](-state/index.md) | [android]<br>abstract class [State](-state/index.md)<br>Represents a single state in the state machine. |

## Properties

| Name | Summary |
|---|---|
| [config](config.md) | [android]<br>val [config](config.md): [StateMachine.Config](-config/index.md)<br>The configuration for this state machine. |
| [isStarted](is-started.md) | [android]<br>var [isStarted](is-started.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Indicates whether the machine has been started. |

## Functions

| Name | Summary |
|---|---|
| [addState](add-state.md) | [android]<br>fun [addState](add-state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), state: [STATE](index.md)): [StateMachine](index.md)&lt;[STATE](index.md)&gt;<br>Adds a new state to the machine. |
| [changeState](change-state.md) | [android]<br>fun [changeState](change-state.md)(stateKey: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), forceChange: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onChangeState: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = config.onChangeState)<br>Changes the current state of the machine. |
| [config](config.md) | [android]<br>inline fun [config](config.md)(configuration: [StateMachine.Config](-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Provides a DSL-like way to configure the [StateMachine.Config](-config/index.md). |
| [getCurrentStateKey](get-current-state-key.md) | [android]<br>fun [getCurrentStateKey](get-current-state-key.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Returns the key of the current state. |
| [newStateInstance](new-state-instance.md) | [android]<br>abstract fun [newStateInstance](new-state-instance.md)(): [STATE](index.md)<br>Creates a new instance of the specific state type. |
| [restoreInstanceState](restore-instance-state.md) | [android]<br>fun [restoreInstanceState](restore-instance-state.md)(savedInstanceState: ERROR CLASS: Symbol not found for Bundle??): [StateMachine](index.md)&lt;[STATE](index.md)&gt;<br>Restores the state of the machine from a Bundle. |
| [saveInstanceState](save-instance-state.md) | [android]<br>fun [saveInstanceState](save-instance-state.md)(): android/os/Bundle<br>Saves the current state of the machine into a Bundle. |
| [setup](setup.md) | [android]<br>inline fun [setup](setup.md)(func: [StateMachine](index.md)&lt;[STATE](index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Configures and starts the [StateMachine](index.md). |
| [shutdown](shutdown.md) | [android]<br>fun [shutdown](shutdown.md)()<br>Shuts down the state machine, clearing states and resetting configuration. |
| [start](start.md) | [android]<br>fun [start](start.md)()<br>Starts the state machine. This must be called after all states are added and initial configuration is set. |
| [state](state.md) | [android]<br>inline fun [state](state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), stateConfig: [STATE](index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine](index.md)&lt;[STATE](index.md)&gt;<br>Adds a new state to the [StateMachine](index.md) using a DSL-like syntax. |