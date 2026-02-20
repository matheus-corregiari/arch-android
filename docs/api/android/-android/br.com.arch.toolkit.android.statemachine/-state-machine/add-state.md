//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)/[addState](add-state.md)

# addState

[android]\
fun [addState](add-state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), state: [STATE](index.md)): [StateMachine](index.md)&lt;[STATE](index.md)&gt;

Adds a new state to the machine.

#### Return

The state machine instance for chaining.

#### Parameters

android

| | |
|---|---|
| key | The unique key for the state. Must be >= 0. |
| state | The state configuration. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | If the machine is already started or the key is negative. |