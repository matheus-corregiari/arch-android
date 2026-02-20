//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage](../index.md)/[ComplexDataParser](index.md)

# ComplexDataParser

[android]\
interface [ComplexDataParser](index.md)

Contract used by storage delegates to serialize and deserialize non-primitive values.

Provide a platform-specific implementation (for example kotlinx.serialization or Moshi) and register it through [Storage.Settings.setComplexDataParser](../-storage/-settings/set-complex-data-parser.md).

## Functions

| Name | Summary |
|---|---|
| [fromJson](from-json.md) | [android]<br>abstract fun &lt;[T](from-json.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [fromJson](from-json.md)(json: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), classToParse: [KClass](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.reflect/-k-class/index.html)&lt;[T](from-json.md)&gt;): [T](from-json.md)<br>Decodes [json](from-json.md) into an instance of [classToParse](from-json.md). |
| [toJson](to-json.md) | [android]<br>abstract fun &lt;[T](to-json.md) : [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html)&gt; [toJson](to-json.md)(data: [T](to-json.md)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>Encodes [data](to-json.md) as JSON. |