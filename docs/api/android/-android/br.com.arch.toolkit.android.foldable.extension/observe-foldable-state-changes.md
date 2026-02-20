//[Android](../../index.md)/[br.com.arch.toolkit.android.foldable.extension](index.md)/[observeFoldableStateChanges](observe-foldable-state-changes.md)

# observeFoldableStateChanges

[android]\
fun [ComponentActivity](https://developer.android.com/reference/kotlin/androidx/activity/ComponentActivity.html).[observeFoldableStateChanges](observe-foldable-state-changes.md)(layout: ERROR CLASS: Symbol not found for ViewGroup, orientation: [FoldingFeature.Orientation](https://developer.android.com/reference/kotlin/androidx/window/layout/FoldingFeature.Orientation.html), listener: [OnFoldableStateChangeListener](-on-foldable-state-change-listener/index.md)): Job

Observes the activity and notifies on device state changes

#### Parameters

android

| | |
|---|---|
| layout | The layout to be used for reference - needed whenever calculating the fold's position on screen |
| orientation | The desired orientation - needed whenever calculating the fold's position on screen |
| listener | Will receive a call to the correct function whenever there is a change |