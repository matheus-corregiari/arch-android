//[Android](../../../../index.md)/[br.com.arch.toolkit.android.statemachine](../../index.md)/[StateMachine](../index.md)/[Config](index.md)

# Config

[android]\
class [Config](index.md)

Configuration for the [StateMachine](../index.md).

## Properties

| Name | Summary |
|---|---|
| [initialState](initial-state.md) | [android]<br>var [initialState](initial-state.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>The key for the initial state. |
| [onChangeState](on-change-state.md) | [android]<br>var [onChangeState](on-change-state.md): ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>The global state change callback. |

## Functions

| Name | Summary |
|---|---|
| [setInitialState](set-initial-state.md) | [android]<br>fun [setInitialState](set-initial-state.md)(initialState: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [StateMachine.Config](index.md)<br>Sets the initial state key. |
| [setOnChangeState](set-on-change-state.md) | [android]<br>fun [setOnChangeState](set-on-change-state.md)(onChangeState: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [StateMachine.Config](index.md)<br>Sets the global state change callback. |