//[Android](../../../index.md)/[br.com.arch.toolkit.android.util](../index.md)/[ObservableValue](index.md)/[ObservableValue](-observable-value.md)

# ObservableValue

[android]\
constructor(initialValue: [T](index.md), getter: () -&gt; [T](index.md)?, setter: ([T](index.md)?) -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)? = null)

#### Parameters

android

| | |
|---|---|
| initialValue | fallback value used before reading from getter. |
| getter | source of truth reader. |
| setter | source of truth writer. When null, [value](value.md) becomes read-only. |