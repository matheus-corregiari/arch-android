//[Android](../../../../index.md)/[br.com.arch.toolkit.android.statemachine](../../index.md)/[ViewStateMachine](../index.md)/[State](index.md)

# State

[android]\
class [State](index.md) : [StateMachine.State](../../-state-machine/-state/index.md)

Represents a single state in a [ViewStateMachine](../index.md).

## Properties

| Name | Summary |
|---|---|
| [enter](../../-state-machine/-state/enter.md) | [android]<br>var [enter](../../-state-machine/-state/enter.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when entering this state. |
| [exit](../../-state-machine/-state/exit.md) | [android]<br>var [exit](../../-state-machine/-state/exit.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when exiting this state. |

## Functions

| Name | Summary |
|---|---|
| [disables](disables.md) | [android]<br>fun [disables](disables.md)(vararg views: ERROR CLASS: Symbol not found for View??): [ViewStateMachine.State](index.md)<br>Sets the views to be disabled when this state is entered.<br>[android]<br>fun [disables](disables.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)vararg ids: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [ViewStateMachine.State](index.md)<br>Sets the view IDs to be disabled when this state is entered. |
| [enables](enables.md) | [android]<br>fun [enables](enables.md)(vararg views: ERROR CLASS: Symbol not found for View??): [ViewStateMachine.State](index.md)<br>Sets the views to be enabled when this state is entered.<br>[android]<br>fun [enables](enables.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)vararg ids: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [ViewStateMachine.State](index.md)<br>Sets the view IDs to be enabled when this state is entered. |
| [gones](gones.md) | [android]<br>fun [gones](gones.md)(vararg views: ERROR CLASS: Symbol not found for View??): [ViewStateMachine.State](index.md)<br>Sets the views to be made gone when this state is entered.<br>[android]<br>fun [gones](gones.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)vararg ids: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [ViewStateMachine.State](index.md)<br>Sets the view IDs to be made gone when this state is entered. |
| [invisibles](invisibles.md) | [android]<br>fun [invisibles](invisibles.md)(vararg views: ERROR CLASS: Symbol not found for View??): [ViewStateMachine.State](index.md)<br>Sets the views to be made invisible when this state is entered.<br>[android]<br>fun [invisibles](invisibles.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)vararg ids: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [ViewStateMachine.State](index.md)<br>Sets the view IDs to be made invisible when this state is entered. |
| [onEnter](on-enter.md) | [android]<br>open override fun [onEnter](on-enter.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ViewStateMachine.State](index.md)<br>Sets a callback to be invoked when entering this state. |
| [onExit](on-exit.md) | [android]<br>open override fun [onExit](on-exit.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [ViewStateMachine.State](index.md)<br>Sets a callback to be invoked when exiting this state. |
| [root](root.md) | [android]<br>fun [root](root.md)(view: ERROR CLASS: Symbol not found for View): [ViewStateMachine.State](index.md)<br>Sets the root view to be used for finding views by ID. |
| [visibles](visibles.md) | [android]<br>fun [visibles](visibles.md)(vararg views: ERROR CLASS: Symbol not found for View??): [ViewStateMachine.State](index.md)<br>Sets the views to be made visible when this state is entered.<br>[android]<br>fun [visibles](visibles.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)vararg ids: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [ViewStateMachine.State](index.md)<br>Sets the view IDs to be made visible when this state is entered. |