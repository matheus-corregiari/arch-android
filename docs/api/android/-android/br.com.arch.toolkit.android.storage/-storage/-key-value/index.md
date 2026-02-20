//[Android](../../../../index.md)/[br.com.arch.toolkit.android.storage](../../index.md)/[Storage](../index.md)/[KeyValue](index.md)

# KeyValue

[android]\
data object [KeyValue](index.md) : [Storage](../index.md)

Provides access to [KeyValueStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md) implementations.

## Properties

| Name | Summary |
|---|---|
| [encrypted](encrypted.md) | [android]<br>val [encrypted](encrypted.md): [SharedPrefStorage.Encrypted](../../../br.com.arch.toolkit.android.storage.keyValue/-shared-pref-storage/-encrypted/index.md)<br>An encrypted [SharedPrefStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-shared-pref-storage/index.md) instance. |
| [memory](memory.md) | [android]<br>val [memory](memory.md): [MemoryStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-memory-storage/index.md)<br>A [MemoryStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-memory-storage/index.md) instance for non-persistent storage. |
| [regular](regular.md) | [android]<br>val [regular](regular.md): [SharedPrefStorage.Regular](../../../br.com.arch.toolkit.android.storage.keyValue/-shared-pref-storage/-regular/index.md)<br>A regular [SharedPrefStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-shared-pref-storage/index.md) instance. |

## Functions

| Name | Summary |
|---|---|
| [init](init.md) | [android]<br>fun [init](init.md)(context: ERROR CLASS: Symbol not found for Context)<br>Initializes the [KeyValue](index.md) storage with the provided Context. |