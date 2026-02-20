//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage](../index.md)/[StorageInitializer](index.md)

# StorageInitializer

[android]\
class [StorageInitializer](index.md) : [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html)&lt;[Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)&gt; 

An [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html) for the storage system, ensuring [Storage.KeyValue](../-storage/-key-value/index.md) is initialized before use.

## Functions

| Name | Summary |
|---|---|
| [create](../../br.com.arch.toolkit.android.util/-toolkit-util-initialization/index.md#541116433%2FFunctions%2F-1252316430) | [android]<br>@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)<br>abstract fun [create](../../br.com.arch.toolkit.android.util/-toolkit-util-initialization/index.md#541116433%2FFunctions%2F-1252316430)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: @EnhancedNullability android/content/Context)<br>[android]<br>open override fun [create](create.md)(context: ERROR CLASS: Symbol not found for Context)<br>Initializes [Storage.KeyValue](../-storage/-key-value/index.md). |
| [dependencies](dependencies.md) | [android]<br>open override fun [dependencies](dependencies.md)(): [MutableList](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html)&lt;*&gt;&gt;&gt;<br>List of dependencies for this initializer. |