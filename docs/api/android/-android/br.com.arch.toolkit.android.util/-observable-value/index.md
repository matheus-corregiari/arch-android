//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ObservableValue](index.md)

# ObservableValue

class [ObservableValue](index.md)&lt;[T](index.md)&gt;(initialValue: [T](index.md), getter: () -&gt; [T](index.md)?, setter: ([T](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null)

Observable wrapper for a value persisted by external getter/setter functions.

The internal state is mirrored in a Flow and [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html), allowing Kotlin-first APIs that are still interoperable with Android Lifecycle observers.

#### Parameters

android

| | |
|---|---|
| initialValue | fallback value used before reading from getter. |
| getter | source of truth reader. |
| setter | source of truth writer. When null, [value](value.md) becomes read-only. |

## Constructors

| | |
|---|---|
| [ObservableValue](-observable-value.md) | [android]<br>constructor(initialValue: [T](index.md), getter: () -&gt; [T](index.md)?, setter: ([T](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [flow](flow.md) | [android]<br>val [flow](flow.md): Flow&lt;[T](index.md)&gt;<br>Cold observable value stream. |
| [liveData](live-data.md) | [android]<br>val [liveData](live-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[T](index.md)&gt;<br>[LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html) view of [flow](flow.md), useful for lifecycle-aware Android observers. |
| [value](value.md) | [android]<br>var [value](value.md): [T](index.md)<br>Current value synchronized with getter. |