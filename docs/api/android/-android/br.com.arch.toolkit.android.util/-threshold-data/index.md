//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ThresholdData](index.md)

# ThresholdData

[android]\
class [ThresholdData](index.md)&lt;[T](index.md)&gt;(duration: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html))

Keeps a single value in memory and automatically invalidates it after duration.

The cache entry is scoped by both `storageName` and `name`. A `get` call with a different scope clears the entry and returns `null`.

This utility is platform-agnostic and can be reused from KMP shared logic.

## Constructors

| | |
|---|---|
| [ThresholdData](-threshold-data.md) | [android]<br>constructor(duration: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [android]<br>fun [clear](clear.md)()<br>Clears all cached metadata and value. |
| [get](get.md) | [android]<br>fun [get](get.md)(storageName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](index.md)?<br>Returns the cached value for the informed scope. |
| [isExpired](is-expired.md) | [android]<br>fun [isExpired](is-expired.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Returns `true` when the cached value is missing or older than duration. |
| [set](set.md) | [android]<br>fun [set](set.md)(storageName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), data: [T](index.md)?)<br>Replaces the current entry. |