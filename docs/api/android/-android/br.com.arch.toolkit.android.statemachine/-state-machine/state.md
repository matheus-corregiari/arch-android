//[Android](../../../index.md)/[br.com.arch.toolkit.android.statemachine](../index.md)/[StateMachine](index.md)/[state](state.md)

# state

[android]\
inline fun [state](state.md)(key: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), stateConfig: [STATE](index.md).() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine](index.md)&lt;[STATE](index.md)&gt;

Adds a new state to the [StateMachine](index.md) using a DSL-like syntax.

#### Parameters

android

| | |
|---|---|
| key | The unique key for the state. |
| stateConfig | A lambda to configure the new state instance. |

#### See also

| |
|---|
| [StateMachine.addState](add-state.md) |

#### Throws

| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-illegal-state-exception/index.html) | If the machine is already started or the key is negative. |