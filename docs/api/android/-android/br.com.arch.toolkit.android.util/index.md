//[Android](../../index.md)/[br.com.arch.toolkit.android.util](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ConfigValue](-config-value/index.md) | [android]<br>data class [ConfigValue](-config-value/index.md)&lt;[T](-config-value/index.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt;(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](-config-value/index.md), storage: () -&gt; [KeyValueStorage](../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md))<br>A wrapper class that provides a way to observe and manage a configuration value stored in [KeyValueStorage](../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md). |
| [ContextProvider](-context-provider/index.md) | [android]<br>object [ContextProvider](-context-provider/index.md)<br>Lightweight global Context accessor backed by [WeakReference](https://developer.android.com/reference/kotlin/java/lang/ref/WeakReference.html). |
| [ObservableValue](-observable-value/index.md) | [android]<br>class [ObservableValue](-observable-value/index.md)&lt;[T](-observable-value/index.md)&gt;(initialValue: [T](-observable-value/index.md), getter: () -&gt; [T](-observable-value/index.md)?, setter: ([T](-observable-value/index.md)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null)<br>Observable wrapper for a value persisted by external getter/setter functions. |
| [ThresholdData](-threshold-data/index.md) | [android]<br>class [ThresholdData](-threshold-data/index.md)&lt;[T](-threshold-data/index.md)&gt;(duration: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html))<br>Keeps a single value in memory and automatically invalidates it after duration. |
| [ToolkitUtilInitialization](-toolkit-util-initialization/index.md) | [android]<br>class [ToolkitUtilInitialization](-toolkit-util-initialization/index.md) : [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html)&lt;[Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)&gt; <br>An [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html) for the toolkit's utility module, ensuring [ContextProvider](-context-provider/index.md) is initialized with the application context. |

## Functions

| Name | Summary |
|---|---|
| [edit](edit.md) | [android]<br>fun ERROR CLASS: Symbol not found for SharedPreferences.[edit](edit.md)(func: ERROR CLASS: Symbol not found for SharedPreferences.Editor.() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html))<br>Extension function to simplify SharedPreferences editing with automatic SharedPreferences.Editor.apply. |
| [get](get.md) | [android]<br>operator fun &lt;[T](get.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; ERROR CLASS: Symbol not found for SharedPreferences.[get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](get.md)?<br>Retrieves a value from SharedPreferences using operator overloading. |
| [set](set.md) | [android]<br>operator fun &lt;[T](set.md)&gt; ERROR CLASS: Symbol not found for SharedPreferences.[set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), value: [T](set.md))<br>Stores a value in SharedPreferences using operator overloading. |