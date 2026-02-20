//[Android](../../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter.stickyheader](../../index.md)/[StickyHeaders](../index.md)/[ViewSetup](index.md)

# ViewSetup

[android]\
interface [ViewSetup](index.md)

Interface for setting up and tearing down the sticky header view.

## Functions

| Name | Summary |
|---|---|
| [setupStickyHeaderView](setup-sticky-header-view.md) | [android]<br>abstract fun [setupStickyHeaderView](setup-sticky-header-view.md)(stickyHeader: ERROR CLASS: Symbol not found for View)<br>Adjusts any necessary properties of the [stickyHeader](setup-sticky-header-view.md) view when it becomes a sticky header. |
| [teardownStickyHeaderView](teardown-sticky-header-view.md) | [android]<br>abstract fun [teardownStickyHeaderView](teardown-sticky-header-view.md)(stickyHeader: ERROR CLASS: Symbol not found for View)<br>Reverts any changes made in [setupStickyHeaderView](setup-sticky-header-view.md). |