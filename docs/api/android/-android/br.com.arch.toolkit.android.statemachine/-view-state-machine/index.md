//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[ViewStateMachine](index.md)

# ViewStateMachine

[android]\
class [ViewStateMachine](index.md) : [StateMachine](../-state-machine/index.md)&lt;[ViewStateMachine.State](-state/index.md)&gt; 

Implementation of [StateMachine](../-state-machine/index.md) This implementation uses View Visibility to make State transitions

## Constructors

| | |
|---|---|
| [ViewStateMachine](-view-state-machine.md) | [android]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [State](-state/index.md) | [android]<br>class [State](-state/index.md) : [StateMachine.State](../-state-machine/-state/index.md)<br>Represents a single state in a [ViewStateMachine](index.md). |

## Properties

| Name | Summary |
|---|---|
| [config](../-state-machine/config.md) | [android]<br>val [config](../-state-machine/config.md): [StateMachine.Config](../-state-machine/-config/index.md)<br>The configuration for this state machine. |
| [isStarted](../-state-machine/is-started.md) | [android]<br>var [isStarted](../-state-machine/is-started.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Indicates whether the machine has been started. |

## Functions

| Name | Summary |
|---|---|
| [addState](../-state-machine/add-state.md) | [android]<br>fun [addState](../-state-machine/add-state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), state: [ViewStateMachine.State](-state/index.md)): [StateMachine](../-state-machine/index.md)&lt;[ViewStateMachine.State](-state/index.md)&gt;<br>Adds a new state to the machine. |
| [changeState](../-state-machine/change-state.md) | [android]<br>fun [changeState](../-state-machine/change-state.md)(stateKey: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), forceChange: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onChangeState: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = config.onChangeState)<br>Changes the current state of the machine. |
| [config](../-state-machine/config.md) | [android]<br>inline fun [config](../-state-machine/config.md)(configuration: [StateMachine.Config](../-state-machine/-config/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Provides a DSL-like way to configure the [StateMachine.Config](../-state-machine/-config/index.md). |
| [getCurrentStateKey](../-state-machine/get-current-state-key.md) | [android]<br>fun [getCurrentStateKey](../-state-machine/get-current-state-key.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Returns the key of the current state. |
| [newStateInstance](new-state-instance.md) | [android]<br>open override fun [newStateInstance](new-state-instance.md)(): [ViewStateMachine.State](-state/index.md)<br>Creates a new instance of the specific state type. |
| [restoreInstanceState](../-state-machine/restore-instance-state.md) | [android]<br>fun [restoreInstanceState](../-state-machine/restore-instance-state.md)(savedInstanceState: ERROR CLASS: Symbol not found for Bundle??): [StateMachine](../-state-machine/index.md)&lt;[ViewStateMachine.State](-state/index.md)&gt;<br>Restores the state of the machine from a Bundle. |
| [saveInstanceState](../-state-machine/save-instance-state.md) | [android]<br>fun [saveInstanceState](../-state-machine/save-instance-state.md)(): android/os/Bundle<br>Saves the current state of the machine into a Bundle. |
| [setup](../-state-machine/setup.md) | [android]<br>inline fun [setup](../-state-machine/setup.md)(func: [StateMachine](../-state-machine/index.md)&lt;[ViewStateMachine.State](-state/index.md)&gt;.() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Configures and starts the [StateMachine](../-state-machine/index.md). |
| [shutdown](../-state-machine/shutdown.md) | [android]<br>fun [shutdown](../-state-machine/shutdown.md)()<br>Shuts down the state machine, clearing states and resetting configuration. |
| [start](../-state-machine/start.md) | [android]<br>fun [start](../-state-machine/start.md)()<br>Starts the state machine. This must be called after all states are added and initial configuration is set. |
| [state](../-state-machine/state.md) | [android]<br>inline fun [state](../-state-machine/state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), stateConfig: [ViewStateMachine.State](-state/index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine](../-state-machine/index.md)&lt;[ViewStateMachine.State](-state/index.md)&gt;<br>Adds a new state to the [StateMachine](../-state-machine/index.md) using a DSL-like syntax. |