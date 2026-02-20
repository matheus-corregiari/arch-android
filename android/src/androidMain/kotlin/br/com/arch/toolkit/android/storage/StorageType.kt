package br.com.arch.toolkit.android.storage

/**
 * Defines the available types of storage within the toolkit.
 */
enum class StorageType {

    /**
     * Volatile storage in memory. Data is lost when the process is killed.
     */
    MEMORY,

    /**
     * Persistent storage using [android.content.SharedPreferences].
     */
    SHARED_PREF,

    /**
     * Persistent and encrypted storage using [androidx.security.crypto.EncryptedSharedPreferences].
     */
    ENCRYPTED_SHARED_PREF
}
