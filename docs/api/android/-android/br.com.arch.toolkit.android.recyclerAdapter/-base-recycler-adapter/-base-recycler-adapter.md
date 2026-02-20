//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter](../index.md)/[BaseRecyclerAdapter](index.md)/[BaseRecyclerAdapter](-base-recycler-adapter.md)

# BaseRecyclerAdapter

[android]\
constructor(differ: [DiffUtil.ItemCallback](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil.ItemCallback.html)&lt;[MODEL](index.md)&gt; = DefaultItemDiffer())

#### Parameters

android

| | |
|---|---|
| MODEL | The type of data to be displayed in the list. |
| differ | The [DiffUtil.ItemCallback](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/DiffUtil.ItemCallback.html) to use for calculating list differences. Defaults to [DefaultItemDiffer](../-default-item-differ/index.md). |