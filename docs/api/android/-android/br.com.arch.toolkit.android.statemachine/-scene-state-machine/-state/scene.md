//[Android](../../../../index.md)/[br.com.arch.toolkit.android.statemachine](../../index.md)/[SceneStateMachine](../index.md)/[State](index.md)/[scene](scene.md)

# scene

[android]\
fun [scene](scene.md)(pair: [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html)&lt;[Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), ERROR CLASS: Symbol not found for ViewGroup&gt;): [SceneStateMachine.State](index.md)

Sets the scene for a [SceneStateMachine.State](index.md) using a [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html) of layout resource ID and container.

#### Return

The [SceneStateMachine.State](index.md) instance for chaining.

#### Parameters

android

| | |
|---|---|
| pair | A [Pair](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-pair/index.html) containing the layout ID and the root ViewGroup. |

[android]\
fun [scene](scene.md)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)sceneLayout: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), container: ERROR CLASS: Symbol not found for ViewGroup): [SceneStateMachine.State](index.md)

Sets the scene for a [SceneStateMachine.State](index.md) using a layout resource ID and container.

#### Return

The [SceneStateMachine.State](index.md) instance for chaining.

#### Parameters

android

| | |
|---|---|
| sceneLayout | The layout resource ID for the scene. |
| container | The root ViewGroup for the scene. |

[android]\
fun [scene](scene.md)(scene: ERROR CLASS: Symbol not found for Scene): [SceneStateMachine.State](index.md)

Sets the scene for a [SceneStateMachine.State](index.md).

#### Return

The [SceneStateMachine.State](index.md) instance for chaining.

#### Parameters

android

| | |
|---|---|
| scene | The Scene instance. |