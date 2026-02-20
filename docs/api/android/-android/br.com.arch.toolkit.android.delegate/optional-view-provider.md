//[Android](../../index.md)/[br.com.arch.toolkit.android.delegate](index.md)/[optionalViewProvider](optional-view-provider.md)

# optionalViewProvider

[android]\
fun &lt;[T](optional-view-provider.md) : ERROR CLASS: Symbol not found for View??&gt; [optionalViewProvider](optional-view-provider.md)(@[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)idRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), @[IdRes](https://developer.android.com/reference/kotlin/androidx/annotation/IdRes.html)parentRes: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = NO_ID, viewStubAutoInflate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [ViewProviderDelegate](-view-provider-delegate/index.md)&lt;[T](optional-view-provider.md)?&gt;

Creates a [ViewProviderDelegate](-view-provider-delegate/index.md) that returns null if the view is not found.

#### Parameters

android

| | |
|---|---|
| idRes | The ID of the view. |
| parentRes | Optional ID of a parent view. |
| viewStubAutoInflate | Whether to auto-inflate if it's a ViewStub. |