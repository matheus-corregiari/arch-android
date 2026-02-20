//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter.stickyheader](../index.md)/[StickyHeaders](index.md)

# StickyHeaders

interface [StickyHeaders](index.md)

Interface to be implemented by [androidx.recyclerview.widget.RecyclerView.Adapter](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.Adapter.html) to support sticky headers.

#### Inheritors

| |
|---|
| [BaseRecyclerAdapter](../../br.com.arch.toolkit.android.recyclerAdapter/-base-recycler-adapter/index.md) |

## Types

| Name | Summary |
|---|---|
| [ViewSetup](-view-setup/index.md) | [android]<br>interface [ViewSetup](-view-setup/index.md)<br>Interface for setting up and tearing down the sticky header view. |

## Functions

| Name | Summary |
|---|---|
| [isStickyHeader](is-sticky-header.md) | [android]<br>abstract fun [isStickyHeader](is-sticky-header.md)(position: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the item at the given [position](is-sticky-header.md) should be a sticky header. |