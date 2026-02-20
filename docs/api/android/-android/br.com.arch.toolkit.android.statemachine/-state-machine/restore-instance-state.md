//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)/[restoreInstanceState](restore-instance-state.md)

# restoreInstanceState

[android]\
fun [restoreInstanceState](restore-instance-state.md)(savedInstanceState: ERROR CLASS: Symbol not found for Bundle??): [StateMachine](index.md)&lt;[STATE](index.md)&gt;

Restores the state of the machine from a Bundle.

#### Return

The state machine instance for chaining.

#### Parameters

android

| | |
|---|---|
| savedInstanceState | The bundle containing the saved state. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | If the machine is already started. |