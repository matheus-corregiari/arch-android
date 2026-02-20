//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter](../index.md)/[ViewBinder](index.md)

# ViewBinder

interface [ViewBinder](index.md)&lt;in [MODEL](index.md)&gt;

Interface to be implemented by custom android.view.Views to handle data binding when used with [BaseRecyclerAdapter](../-base-recycler-adapter/index.md).

#### Parameters

android

| | |
|---|---|
| MODEL | The type of data to be bound to the view. |

## Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | [android]<br>abstract fun [bind](bind.md)(model: [MODEL](index.md))<br>Binds the [model](bind.md) data to the view. |