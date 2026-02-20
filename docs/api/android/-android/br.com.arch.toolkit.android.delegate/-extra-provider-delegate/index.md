//[Android](../../../index.md)/[br.com.arch.toolkit.android.delegate](../index.md)/[ExtraProviderDelegate](index.md)

# ExtraProviderDelegate

class [ExtraProviderDelegate](index.md)&lt;[T](index.md)&gt;(extraName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), type: [ExtraType](../-extra-type/index.md), defaultValue: () -&gt; [T](index.md))

A property delegate for retrieving and optionally caching extras from [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html) intents or [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html) arguments.

It also supports retrieving values from URI query parameters if the type is [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html).

#### Parameters

android

| | |
|---|---|
| T | The type of the extra. |

## Constructors

| | |
|---|---|
| [ExtraProviderDelegate](-extra-provider-delegate.md) | [android]<br>constructor(extraName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), type: [ExtraType](../-extra-type/index.md), defaultValue: () -&gt; [T](index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | [android]<br>operator fun [getValue](get-value.md)(thisRef: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md)<br>operator fun [getValue](get-value.md)(thisRef: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;): [T](index.md) |
| [setValue](set-value.md) | [android]<br>operator fun [setValue](set-value.md)(thisRef: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md))<br>operator fun [setValue](set-value.md)(thisRef: [Fragment](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment.html), property: [KProperty](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-property/index.html)&lt;*&gt;, value: [T](index.md)) |