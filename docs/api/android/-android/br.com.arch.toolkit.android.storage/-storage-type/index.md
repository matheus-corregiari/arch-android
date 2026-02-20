//[Android](../../../index.md)/[br.com.arch.toolkit.android.storage](../index.md)/[StorageType](index.md)

# StorageType

[android]\
enum [StorageType](index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[StorageType](index.md)&gt; 

Defines the available types of storage within the toolkit.

## Entries

| | |
|---|---|
| [MEMORY](-m-e-m-o-r-y/index.md) | [android]<br>[MEMORY](-m-e-m-o-r-y/index.md)<br>Volatile storage in memory. Data is lost when the process is killed. |
| [SHARED_PREF](-s-h-a-r-e-d_-p-r-e-f/index.md) | [android]<br>[SHARED_PREF](-s-h-a-r-e-d_-p-r-e-f/index.md)<br>Persistent storage using android.content.SharedPreferences. |
| [ENCRYPTED_SHARED_PREF](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md) | [android]<br>[ENCRYPTED_SHARED_PREF](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md)<br>Persistent and encrypted storage using [androidx.security.crypto.EncryptedSharedPreferences](https://developer.android.com/reference/kotlin/androidx/security/crypto/EncryptedSharedPreferences.html). |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [android]<br>val [entries](entries.md): [EnumEntries](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.enums/-enum-entries/index.html)&lt;[StorageType](index.md)&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md#-372974862%2FProperties%2F-1252316430) | [android]<br>val [name](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md#-372974862%2FProperties%2F-1252316430): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [ordinal](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md#-739389684%2FProperties%2F-1252316430) | [android]<br>val [ordinal](-e-n-c-r-y-p-t-e-d_-s-h-a-r-e-d_-p-r-e-f/index.md#-739389684%2FProperties%2F-1252316430): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [valueOf](value-of.md) | [android]<br>fun [valueOf](value-of.md)(value: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [StorageType](index.md)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [android]<br>fun [values](values.md)(): [Array](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/index.html)&lt;[StorageType](index.md)&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |