//[Android](../../../index.md)/[br.com.arch.toolkit.android.foldable.extension](../index.md)/[OnFoldableStateChangeListener](index.md)

# OnFoldableStateChangeListener

[android]\
interface [OnFoldableStateChangeListener](index.md)

## Functions

| Name | Summary |
|---|---|
| [onChangeState](on-change-state.md) | [android]<br>open fun [onChangeState](on-change-state.md)(isFolded: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html))<br>Called whenever there is a state change |
| [onClosed](on-closed.md) | [android]<br>open fun [onClosed](on-closed.md)()<br>Called whenever the device changes to closed state |
| [onHalfOpen](on-half-open.md) | [android]<br>open fun [onHalfOpen](on-half-open.md)(foldPosition: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html))<br>Called whenever the device changes to half open state |
| [onOpenFlat](on-open-flat.md) | [android]<br>open fun [onOpenFlat](on-open-flat.md)(foldPosition: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html))<br>Called whenever the device changes to fully open state |
| [onWrongOrientation](on-wrong-orientation.md) | [android]<br>open fun [onWrongOrientation](on-wrong-orientation.md)()<br>Called whenever the device changes to the unwanted orientation |