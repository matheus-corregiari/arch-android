//[Android](../../../../index.md)/[br.com.arch.toolkit.android.statemachine](../../index.md)/[StateMachine](../index.md)/[State](index.md)

# State

abstract class [State](index.md)

Represents a single state in the state machine.

#### Inheritors

| |
|---|
| [State](../../-scene-state-machine/-state/index.md) |
| [State](../../-view-state-machine/-state/index.md) |

## Constructors

| | |
|---|---|
| [State](-state.md) | [android]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [enter](enter.md) | [android]<br>var [enter](enter.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when entering this state. |
| [exit](exit.md) | [android]<br>var [exit](exit.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when exiting this state. |

## Functions

| Name | Summary |
|---|---|
| [onEnter](on-enter.md) | [android]<br>open fun [onEnter](on-enter.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine.State](index.md)<br>Sets a callback to be invoked when entering this state. |
| [onExit](on-exit.md) | [android]<br>open fun [onExit](on-exit.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine.State](index.md)<br>Sets a callback to be invoked when exiting this state. |