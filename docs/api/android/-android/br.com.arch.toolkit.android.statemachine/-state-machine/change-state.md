//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)/[changeState](change-state.md)

# changeState

[android]\
fun [changeState](change-state.md)(stateKey: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), forceChange: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, onChangeState: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = config.onChangeState)

Changes the current state of the machine.

#### Parameters

android

| | |
|---|---|
| stateKey | The key of the state to become active. |
| forceChange | If `true`, transitions even if `stateKey` is the current state. |
| onChangeState | Optional callback to be invoked before the state change. |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | If the machine is not started or the state key is not found. |