//[Android](../../../../index.md)/[br.com.arch.toolkit.android.storage](../../index.md)/[Storage](../index.md)/[Settings](index.md)

# Settings

[android]\
data object [Settings](index.md) : [Storage](../index.md)

Configuration settings for the storage system.

## Properties

| Name | Summary |
|---|---|
| [complexDataParser](complex-data-parser.md) | [android]<br>var [complexDataParser](complex-data-parser.md): [ComplexDataParser](../../-complex-data-parser/index.md)?<br>The global [ComplexDataParser](../../-complex-data-parser/index.md) used for serializing/deserializing complex objects. |
| [keyValue](key-value.md) | [android]<br>var [keyValue](key-value.md): [KeyValueStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md)<br>The default [KeyValueStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md) implementation. |
| [threshold](threshold.md) | [android]<br>var [threshold](threshold.md): [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)<br>The default threshold duration for [br.com.arch.toolkit.android.util.ThresholdData](../../../br.com.arch.toolkit.android.util/-threshold-data/index.md). |

## Functions

| Name | Summary |
|---|---|
| [setComplexDataParser](set-complex-data-parser.md) | [android]<br>fun [setComplexDataParser](set-complex-data-parser.md)(parser: [ComplexDataParser](../../-complex-data-parser/index.md)): [Storage.Settings](index.md)<br>Sets the global [ComplexDataParser](../../-complex-data-parser/index.md). |
| [setDefaultStorage](set-default-storage.md) | [android]<br>fun [setDefaultStorage](set-default-storage.md)(storage: [KeyValueStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md)): [Storage.Settings](index.md)<br>Sets the default [KeyValueStorage](../../../br.com.arch.toolkit.android.storage.keyValue/-key-value-storage/index.md). |
| [setDefaultThreshold](set-default-threshold.md) | [android]<br>fun [setDefaultThreshold](set-default-threshold.md)(threshold: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)): [Storage.Settings](index.md)<br>Sets the default threshold duration. |