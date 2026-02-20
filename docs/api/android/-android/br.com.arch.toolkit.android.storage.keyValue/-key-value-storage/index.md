//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage.keyValue](../index.md)/[KeyValueStorage](index.md)

# KeyValueStorage

interface [KeyValueStorage](index.md)

Generic key-value storage abstraction used across the toolkit.

Implementations may be in-memory, SharedPreferences-based, encrypted, or custom.

#### Inheritors

| |
|---|
| [MemoryStorage](../-memory-storage/index.md) |
| [SharedPrefStorage](../-shared-pref-storage/index.md) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [android]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Unique storage name. |
| [type](type.md) | [android]<br>abstract val [type](type.md): [StorageType](../../br.com.arch.toolkit.android.storage/-storage-type/index.md)<br>Storage backend category. |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [android]<br>abstract fun [clear](clear.md)()<br>Removes every entry. |
| [contains](contains.md) | [android]<br>abstract fun [contains](contains.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Returns `true` when [key](contains.md) exists. |
| [get](get.md) | [android]<br>abstract operator fun &lt;[T](get.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](get.md)?<br>Reads a value associated with [key](get.md).<br>[android]<br>open operator fun &lt;[T](get.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](get.md)): [T](get.md)<br>Reads a value or returns [default](get.md) when absent. |
| [keys](keys.md) | [android]<br>abstract fun [keys](keys.md)(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;<br>Snapshot of all keys currently stored. |
| [remove](remove.md) | [android]<br>abstract fun [remove](remove.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Removes a single key.<br>[android]<br>open fun [remove](remove.md)(regex: [Regex](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-regex/index.html))<br>Removes every key that matches [regex](remove.md). |
| [set](set.md) | [android]<br>abstract operator fun &lt;[T](set.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), value: [T](set.md)?)<br>Stores [value](set.md) under [key](set.md). |
| [size](size.md) | [android]<br>abstract fun [size](size.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Total number of stored entries. |