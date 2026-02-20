//[Android](../../index.md)/[br.com.arch.toolkit.android.util](index.md)/[set](set.md)

# set

[android]\
operator fun &lt;[T](set.md)&gt; ERROR CLASS: Symbol not found for SharedPreferences.[set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), value: [T](set.md))

Stores a value in SharedPreferences using operator overloading.

Supported types: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html), [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html), [Float](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/index.html), [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html), [Double](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/index.html) (stored as String), and null (removes the key).

#### Parameters

android

| | |
|---|---|
| key | The name of the preference to modify. |
| value | The new value for the preference. |

#### Throws

| | |
|---|---|
| [UnsupportedOperationException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unsupported-operation-exception/index.html) | If the value type is not supported. |