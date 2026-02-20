//[Android](../../index.md)/[br.com.arch.toolkit.android.storage.keyValue](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [KeyValueStorage](-key-value-storage/index.md) | [android]<br>interface [KeyValueStorage](-key-value-storage/index.md)<br>Generic key-value storage abstraction used across the toolkit. |
| [MemoryStorage](-memory-storage/index.md) | [android]<br>class [MemoryStorage](-memory-storage/index.md) : [KeyValueStorage](-key-value-storage/index.md)<br>An in-memory implementation of [KeyValueStorage](-key-value-storage/index.md). |
| [SharedPrefStorage](-shared-pref-storage/index.md) | [android]<br>sealed class [SharedPrefStorage](-shared-pref-storage/index.md) : [KeyValueStorage](-key-value-storage/index.md)<br>An implementation of [KeyValueStorage](-key-value-storage/index.md) that uses SharedPreferences for persistence. |