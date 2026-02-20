//[Android](../../../index.md)/[br.com.arch.toolkit.android.recyclerAdapter](../index.md)/[SimpleStickyAdapter](index.md)/[SimpleStickyAdapter](-simple-sticky-adapter.md)

# SimpleStickyAdapter

[android]\
constructor(itemCreator: (@R|kotlin/ParameterName|(name = String(context))  ERROR CLASS: Symbol not found for Context) -&gt; [VIEW](index.md), stickyItemCreator: (@R|kotlin/ParameterName|(name = String(context))  ERROR CLASS: Symbol not found for Context) -&gt; [STICKY_VIEW](index.md))

#### Parameters

android

| | |
|---|---|
| MODEL | The type of data to be displayed. Must implement [StickyHeaderModel](../../br.com.arch.toolkit.android.recyclerAdapter.stickyheader/-sticky-header-model/index.md). |
| VIEW | The type of the view for regular items. Must extend View and implement [ViewBinder](../-view-binder/index.md). |
| STICKY_VIEW | The type of the view for sticky headers. Must extend View and implement [ViewBinder](../-view-binder/index.md). |