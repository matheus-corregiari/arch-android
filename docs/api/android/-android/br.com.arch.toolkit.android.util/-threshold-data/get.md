//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ThresholdData](index.md)/[get](get.md)

# get

[android]\
fun [get](get.md)(storageName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [T](index.md)?

Returns the cached value for the informed scope.

If the entry is expired or the scope does not match, this cache is cleared and `null` is returned.