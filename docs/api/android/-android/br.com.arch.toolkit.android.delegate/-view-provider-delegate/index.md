//[Android](../../../index.md)/[br.com.arch.toolkit.android.delegate](../index.md)/[ViewProviderDelegate](index.md)

# ViewProviderDelegate

class [ViewProviderDelegate](index.md)&lt;out [T](index.md)&gt;

A property delegate for finding and caching Views.

It supports [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), View, and [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html).

#### Parameters

android

| | |
|---|---|
| T | The type of the View. |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [android]<br>operator fun [getValue](get-value.md)(thisRef: ERROR CLASS: Symbol not found for View, property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>operator fun [getValue](get-value.md)(thisRef: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>operator fun [getValue](get-value.md)(thisRef: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>operator fun [getValue](get-value.md)(thisRef: [RecyclerView.ViewHolder](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView.ViewHolder.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md) |