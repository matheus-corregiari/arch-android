//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter](../index.md)/[DefaultItemDiffer](index.md)

# DefaultItemDiffer

class [DefaultItemDiffer](index.md)&lt;[MODEL](index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; : [DiffUtil.ItemCallback](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil.ItemCallback.html)&lt;[MODEL](index.md)&gt; 

A default implementation of [DiffUtil.ItemCallback](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil.ItemCallback.html) that uses the equality operator (==) for both item and content comparison.

#### Parameters

android

| | |
|---|---|
| MODEL | The type of data items being compared. |

## Constructors

| | |
|---|---|
| [DefaultItemDiffer](-default-item-differ.md) | [android]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | [android]<br>open override fun [areContentsTheSame](are-contents-the-same.md)(oldItem: [MODEL](index.md), newItem: [MODEL](index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if two items have the same content using equality (==). |
| [areItemsTheSame](are-items-the-same.md) | [android]<br>open override fun [areItemsTheSame](are-items-the-same.md)(oldItem: [MODEL](index.md), newItem: [MODEL](index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if two items represent the same object using equality (==). |
| [getChangePayload](index.md#-1309710208%2FFunctions%2F-1252316430) | [android]<br>@[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)<br>open fun [getChangePayload](index.md#-1309710208%2FFunctions%2F-1252316430)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)oldItem: [MODEL](index.md) &amp; [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html), @[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)newItem: [MODEL](index.md) &amp; [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)): [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)? |