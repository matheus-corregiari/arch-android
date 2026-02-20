//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ContextProvider](index.md)

# ContextProvider

[android]\
object [ContextProvider](index.md)

Lightweight global Context accessor backed by [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html).

The latest created/resumed Activity is preferred, with Application as fallback. Because references are weak, consumers should not cache [current](current.md) strongly for long periods.

## Properties

| Name | Summary |
|---|---|
| [current](current.md) | [android]<br>val [current](current.md): ERROR CLASS: Symbol not found for Context??<br>Last available Context, or `null` if it has been garbage collected. |

## Functions

| Name | Summary |
|---|---|
| [init](init.md) | [android]<br>fun [init](init.md)(context: ERROR CLASS: Symbol not found for Context)<br>Initializes the provider with any Android Context. |
| [register](register.md) | [android]<br>fun [register](register.md)(application: ERROR CLASS: Symbol not found for Application)<br>Registers activity lifecycle callbacks in [application](register.md) to keep [current](current.md) up to date. |