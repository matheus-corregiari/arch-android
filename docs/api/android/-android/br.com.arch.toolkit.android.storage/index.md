//[Android](../../index.md)/[br.com.arch.toolkit.android.storage](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ComplexDataParser](-complex-data-parser/index.md) | [android]<br>interface [ComplexDataParser](-complex-data-parser/index.md)<br>Contract used by storage delegates to serialize and deserialize non-primitive values. |
| [Storage](-storage/index.md) | [android]<br>sealed class [Storage](-storage/index.md)<br>Entry point for different types of storage available in the toolkit. |
| [StorageInitializer](-storage-initializer/index.md) | [android]<br>class [StorageInitializer](-storage-initializer/index.md) : [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html)&lt;[Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)&gt; <br>An [Initializer](https://developer.android.com/reference/kotlin/androidx/startup/Initializer.html) for the storage system, ensuring [Storage.KeyValue](-storage/-key-value/index.md) is initialized before use. |
| [StorageType](-storage-type/index.md) | [android]<br>enum [StorageType](-storage-type/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[StorageType](-storage-type/index.md)&gt; <br>Defines the available types of storage within the toolkit. |