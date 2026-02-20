//[Android](../../index.md)/[br.com.arch.toolkit.android.storage.delegate](index.md)/[keyValueStorage](key-value-storage.md)

# keyValueStorage

[android]\
inline fun &lt;[T](key-value-storage.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [keyValueStorage](key-value-storage.md)(name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [OptionalStorageDelegate](-optional-storage-delegate/index.md)&lt;[T](key-value-storage.md)&gt;

Creates an [OptionalStorageDelegate](-optional-storage-delegate/index.md) for the specified type and name.

#### Parameters

android

| | |
|---|---|
| T | The type of data to store. |
| name | The key name. |

[android]\
inline fun &lt;[T](key-value-storage.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [keyValueStorage](key-value-storage.md)(noinline name: () -&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [OptionalStorageDelegate](-optional-storage-delegate/index.md)&lt;[T](key-value-storage.md)&gt;

Creates an [OptionalStorageDelegate](-optional-storage-delegate/index.md) for the specified type and name provider.

#### Parameters

android

| | |
|---|---|
| T | The type of data to store. |
| name | A lambda providing the key name. |

[android]\
fun &lt;[T](key-value-storage.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [keyValueStorage](key-value-storage.md)(classToParse: [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [T](key-value-storage.md)&gt;, name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [OptionalStorageDelegate](-optional-storage-delegate/index.md)&lt;[T](key-value-storage.md)&gt;

Creates an [OptionalStorageDelegate](-optional-storage-delegate/index.md) for the specified [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html) and name.

#### Parameters

android

| | |
|---|---|
| classToParse | The class of the data to store. |
| name | The key name. |

[android]\
fun &lt;[T](key-value-storage.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [keyValueStorage](key-value-storage.md)(classToParse: [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;out [T](key-value-storage.md)&gt;, name: () -&gt; [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [OptionalStorageDelegate](-optional-storage-delegate/index.md)&lt;[T](key-value-storage.md)&gt;

Creates an [OptionalStorageDelegate](-optional-storage-delegate/index.md) for the specified [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html) and name provider.

#### Parameters

android

| | |
|---|---|
| classToParse | The class of the data to store. |
| name | A lambda providing the key name. |