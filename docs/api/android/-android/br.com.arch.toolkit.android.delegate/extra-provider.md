//[Android](../../index.md)/[br.com.arch.toolkit.android.delegate](index.md)/[extraProvider](extra-provider.md)

# extraProvider

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)?&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) for an optional extra.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)?&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) for an optional extra with state keeping configuration.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](extra-provider.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with a default value.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), default: [T](extra-provider.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with state keeping and a default value.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), type: [ExtraType](-extra-type/index.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)?&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with a specific [ExtraType](-extra-type/index.md).

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), type: [ExtraType](-extra-type/index.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)?&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with state keeping and a specific [ExtraType](-extra-type/index.md).

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), type: [ExtraType](-extra-type/index.md), default: [T](extra-provider.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with a specific [ExtraType](-extra-type/index.md) and default value.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), type: [ExtraType](-extra-type/index.md), default: [T](extra-provider.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with state keeping, specific [ExtraType](-extra-type/index.md) and default value.

[android]\
fun &lt;[T](extra-provider.md)&gt; [extraProvider](extra-provider.md)(extra: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), keepState: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), type: [ExtraType](-extra-type/index.md), default: () -&gt; [T](extra-provider.md)): [ExtraProviderDelegate](-extra-provider-delegate/index.md)&lt;[T](extra-provider.md)&gt;

Creates an [ExtraProviderDelegate](-extra-provider-delegate/index.md) with state keeping, specific [ExtraType](-extra-type/index.md) and a default value provider.