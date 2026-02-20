//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ConfigValue](index.md)

# ConfigValue

data class [ConfigValue](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](index.md), storage: () -&gt; [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md))

A wrapper class that provides a way to observe and manage a configuration value stored in [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md).

It provides both [androidx.lifecycle.LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html) and kotlinx.coroutines.flow.Flow for observation.

#### Parameters

android

| | |
|---|---|
| T | The type of the value being stored. |

## Constructors

| | |
|---|---|
| [ConfigValue](-config-value.md) | [android]<br>constructor(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](index.md), storage: () -&gt; [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [flow](flow.md) | [android]<br>val [flow](flow.md): Flow&lt;[T](index.md)&gt;<br>Returns a kotlinx.coroutines.flow.Flow to observe changes to the value. |
| [liveData](live-data.md) | [android]<br>val [liveData](live-data.md): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[T](index.md)&gt;<br>Returns a [androidx.lifecycle.LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html) object to observe changes to the value. |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [android]<br>fun [get](get.md)(): [T](index.md)<br>Retrieves the current value. |
| [set](set.md) | [android]<br>fun [set](set.md)(value: [T](index.md))<br>Updates the value and persists it to storage. |