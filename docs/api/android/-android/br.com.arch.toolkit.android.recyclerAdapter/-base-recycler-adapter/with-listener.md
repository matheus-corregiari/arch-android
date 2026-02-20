//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter](../index.md)/[BaseRecyclerAdapter](index.md)/[withListener](with-listener.md)

# withListener

[android]\
fun [withListener](with-listener.md)(onItemClick: ([MODEL](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseRecyclerAdapter](index.md)&lt;[MODEL](index.md)&gt;

Sets a global click listener for all items.

#### Return

The adapter instance for chaining.

#### Parameters

android

| | |
|---|---|
| onItemClick | The listener to be called on item click. |

[android]\
fun [withListener](with-listener.md)(itemType: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), onItemClick: (model: [MODEL](index.md)) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [BaseRecyclerAdapter](index.md)&lt;[MODEL](index.md)&gt;

Sets a click listener for a specific view type.

#### Return

The adapter instance for chaining.

#### Parameters

android

| | |
|---|---|
| itemType | The view type identifier. |
| onItemClick | The listener to be called on item click. |