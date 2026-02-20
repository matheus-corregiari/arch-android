//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage.keyValue](../index.md)/[SharedPrefStorage](index.md)

# SharedPrefStorage

sealed class [SharedPrefStorage](index.md) : [KeyValueStorage](../-key-value-storage/index.md)

An implementation of [KeyValueStorage](../-key-value-storage/index.md) that uses SharedPreferences for persistence.

It includes a memory cache ([MemoryStorage](../-memory-storage/index.md)) for faster access and is thread-safe.

#### Inheritors

| |
|---|
| [Regular](-regular/index.md) |
| [Encrypted](-encrypted/index.md) |

## Types

| Name | Summary |
|---|---|
| [Encrypted](-encrypted/index.md) | [android]<br>class [Encrypted](-encrypted/index.md)(context: ERROR CLASS: Symbol not found for Context, val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [SharedPrefStorage](index.md)<br>An encrypted [SharedPrefStorage](index.md) using [EncryptedSharedPreferences](https://developer.android.com/reference/kotlin/androidx/security/crypto/EncryptedSharedPreferences.html). |
| [Regular](-regular/index.md) | [android]<br>class [Regular](-regular/index.md)(context: ERROR CLASS: Symbol not found for Context, val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) : [SharedPrefStorage](index.md)<br>A regular, non-encrypted [SharedPrefStorage](index.md). |

## Properties

| Name | Summary |
|---|---|
| [name](../-key-value-storage/name.md) | [android]<br>abstract val [name](../-key-value-storage/name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Unique storage name. |
| [type](type.md) | [android]<br>open override val [type](type.md): [StorageType](../../br.com.arch.toolkit.android.storage/-storage-type/index.md)<br>The type of storage ([StorageType.SHARED_PREF](../../br.com.arch.toolkit.android.storage/-storage-type/-s-h-a-r-e-d_-p-r-e-f/index.md) or [StorageType.ENCRYPTED_SHARED_PREF](../../br.com.arch.toolkit.android.storage/-storage-type/-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md)). |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [android]<br>open override fun [clear](clear.md)()<br>Removes every entry. |
| [contains](contains.md) | [android]<br>open override fun [contains](contains.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Returns `true` when [key](../-key-value-storage/contains.md) exists. |
| [get](../-key-value-storage/get.md) | [android]<br>open operator fun &lt;[T](../-key-value-storage/get.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [get](../-key-value-storage/get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), default: [T](../-key-value-storage/get.md)): [T](../-key-value-storage/get.md)<br>Reads a value or returns [default](../-key-value-storage/get.md) when absent.<br>[android]<br>open operator override fun &lt;[T](get.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](get.md)?<br>Reads a value associated with [key](../-key-value-storage/get.md). |
| [keys](keys.md) | [android]<br>open override fun [keys](keys.md)(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;<br>Snapshot of all keys currently stored. |
| [remove](../-key-value-storage/remove.md) | [android]<br>open fun [remove](../-key-value-storage/remove.md)(regex: [Regex](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-regex/index.html))<br>Removes every key that matches [regex](../-key-value-storage/remove.md).<br>[android]<br>open override fun [remove](remove.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Removes a single key. |
| [set](set.md) | [android]<br>open operator override fun &lt;[T](set.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), value: [T](set.md)?)<br>Stores [value](../-key-value-storage/set.md) under [key](../-key-value-storage/set.md). |
| [size](size.md) | [android]<br>open override fun [size](size.md)(): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Total number of stored entries. |