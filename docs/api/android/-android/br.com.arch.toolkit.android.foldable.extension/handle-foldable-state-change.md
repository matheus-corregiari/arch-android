//[Android](../../index.md)/[br.com.arch.toolkit.android.foldable.extension](index.md)/[handleFoldableStateChange](handle-foldable-state-change.md)

# handleFoldableStateChange

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), onChangeState: (isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| onChangeState | Called whenever there is a state change |

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), onChangeState: (isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onWrongOrientation: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| onChangeState | Called whenever there is a state change |
| onWrongOrientation | Called whenever the device changes to the unwanted orientation |

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), onChangeState: (isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onWrongOrientation: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onOpenFlat: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| onChangeState | Called whenever there is a state change |
| onWrongOrientation | Called whenever the device changes to the unwanted orientation |
| onOpenFlat | Called whenever the device changes to fully open state |

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), onChangeState: (isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onWrongOrientation: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onOpenFlat: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onHalfOpen: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| onChangeState | Called whenever there is a state change |
| onWrongOrientation | Called whenever the device changes to the unwanted orientation |
| onOpenFlat | Called whenever the device changes to fully open state |
| onHalfOpen | Called whenever the device changes to half open state |

[android]\
fun [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html).[handleFoldableStateChange](handle-foldable-state-change.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)reactiveGuideId: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), onChangeState: (isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onWrongOrientation: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onOpenFlat: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onHalfOpen: ([Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?, onClosed: () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)?): Job

Observes the activity and handles device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| reactiveGuideId | The ReactiveGuide's id - needed for dividing screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| onChangeState | Called whenever there is a state change |
| onWrongOrientation | Called whenever the device changes to the unwanted orientation |
| onOpenFlat | Called whenever the device changes to fully open state |
| onHalfOpen | Called whenever the device changes to half open state |
| onClosed | Called whenever the device changes to closed state |