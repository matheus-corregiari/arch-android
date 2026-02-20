//[Android](../../../../index.md)/[br.com.arch.toolkit.android.statemachine](../../index.md)/[SceneStateMachine](../index.md)/[State](index.md)

# State

[android]\
class [State](index.md) : [StateMachine.State](../../-state-machine/-state/index.md)

Represents a single state in a [SceneStateMachine](../index.md).

## Properties

| Name | Summary |
|---|---|
| [enter](../../-state-machine/-state/enter.md) | [android]<br>var [enter](../../-state-machine/-state/enter.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when entering this state. |
| [exit](../../-state-machine/-state/exit.md) | [android]<br>var [exit](../../-state-machine/-state/exit.md): () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?<br>Callback to be invoked when exiting this state. |

## Functions

| Name | Summary |
|---|---|
| [onEnter](on-enter.md) | [android]<br>open override fun [onEnter](on-enter.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [SceneStateMachine.State](index.md)<br>Sets a callback to be invoked when entering this state. |
| [onExit](on-exit.md) | [android]<br>open override fun [onExit](on-exit.md)(callback: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [SceneStateMachine.State](index.md)<br>Sets a callback to be invoked when exiting this state. |
| [scene](scene.md) | [android]<br>fun [scene](scene.md)(scene: ERROR CLASS: Symbol not found for Scene): [SceneStateMachine.State](index.md)<br>Sets the scene for a [SceneStateMachine.State](index.md).<br>[android]<br>fun [scene](scene.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), ERROR CLASS: Symbol not found for ViewGroup&gt;): [SceneStateMachine.State](index.md)<br>Sets the scene for a [SceneStateMachine.State](index.md) using a [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html) of layout resource ID and container.<br>[android]<br>fun [scene](scene.md)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)sceneLayout: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), container: ERROR CLASS: Symbol not found for ViewGroup): [SceneStateMachine.State](index.md)<br>Sets the scene for a [SceneStateMachine.State](index.md) using a layout resource ID and container. |
| [transition](transition.md) | [android]<br>fun [transition](transition.md)(transition: ERROR CLASS: Symbol not found for Transition): [SceneStateMachine.State](index.md)<br>Sets the transition to be used when entering this state. |