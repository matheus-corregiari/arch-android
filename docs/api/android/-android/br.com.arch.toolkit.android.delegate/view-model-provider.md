//[Android](../../index.md)/[br.com.arch.toolkit.android.delegate](index.md)/[viewModelProvider](view-model-provider.md)

# viewModelProvider

[android]\
inline fun &lt;[T](view-model-provider.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; [viewModelProvider](view-model-provider.md)(): [ViewModelProviderDelegate](-view-model-provider-delegate/index.md)&lt;[T](view-model-provider.md)&gt;

Creates a [ViewModelProviderDelegate](-view-model-provider-delegate/index.md) for the specified [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html) type.

[android]\
fun &lt;[T](view-model-provider.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)&gt; [viewModelProvider](view-model-provider.md)(kClass: [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;[T](view-model-provider.md)&gt;): [ViewModelProviderDelegate](-view-model-provider-delegate/index.md)&lt;[T](view-model-provider.md)&gt;

Creates a [ViewModelProviderDelegate](-view-model-provider-delegate/index.md) for the specified [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html).

#### Parameters

android

| | |
|---|---|
| kClass | The class of the [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html). |