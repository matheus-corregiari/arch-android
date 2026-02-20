//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage.delegate](../index.md)/[NonOptionalStorageDelegate](index.md)

# NonOptionalStorageDelegate

data class [NonOptionalStorageDelegate](index.md)&lt;[T](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; : [StorageDelegate](../-storage-delegate/index.md)&lt;[T](index.md)&gt; 

A property delegate for non-optional values in [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md).

It wraps an [OptionalStorageDelegate](../-optional-storage-delegate/index.md) and provides a default value if the stored value is null.

#### Parameters

android

| | |
|---|---|
| T | The type of data to store. |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [android]<br>operator fun [getValue](get-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md) |
| [setValue](set-value.md) | [android]<br>operator fun [setValue](set-value.md)(thisRef: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)?, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md)) |
| [storage](storage.md) | [android]<br>fun [storage](storage.md)(storage: [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md)): [NonOptionalStorageDelegate](index.md)&lt;[T](index.md)&gt;<br>Configures the [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md) for this delegate.<br>[android]<br>fun [storage](storage.md)(storage: () -&gt; [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md)): [NonOptionalStorageDelegate](index.md)&lt;[T](index.md)&gt;<br>Configures the [KeyValueStorage](../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md) provider for this delegate. |
| [threshold](threshold.md) | [android]<br>fun [threshold](threshold.md)(threshold: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)): [NonOptionalStorageDelegate](index.md)&lt;[T](index.md)&gt;<br>Configures the expiration threshold for the memory cache. |