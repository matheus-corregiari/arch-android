package br.com.arch.toolkit.android.storage

import android.content.Context
import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage
import br.com.arch.toolkit.android.storage.keyValue.MemoryStorage
import br.com.arch.toolkit.android.storage.keyValue.SharedPrefStorage
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * Entry point for different types of storage available in the toolkit.
 */
sealed class Storage {

    /**
     * Provides access to [KeyValueStorage] implementations.
     */
    data object KeyValue : Storage() {
        private var _encrypted: SharedPrefStorage.Encrypted? = null
        private var _regular: SharedPrefStorage.Regular? = null

        /**
         * A [MemoryStorage] instance for non-persistent storage.
         */
        val memory = MemoryStorage("default-memory")

        /**
         * An encrypted [SharedPrefStorage] instance.
         *
         * @throws IllegalArgumentException if not initialized via [init].
         */
        val encrypted: SharedPrefStorage.Encrypted
            get() = requireNotNull(
                _encrypted
            ) { "Not initialized, Be aware to call init() before use" }

        /**
         * A regular [SharedPrefStorage] instance.
         *
         * @throws IllegalArgumentException if not initialized via [init].
         */
        val regular: SharedPrefStorage.Regular
            get() = requireNotNull(
                _regular
            ) { "Not initialized, Be aware to call init() before use" }

        /**
         * Initializes the [KeyValue] storage with the provided [Context].
         *
         * @param context The application context.
         */
        fun init(context: Context) {
            _encrypted = SharedPrefStorage.Encrypted(context, "default-encrypted")
            _regular = SharedPrefStorage.Regular(context, "default-regular")
        }
    }

    /**
     * Configuration settings for the storage system.
     */
    data object Settings : Storage() {
        /**
         * The default threshold duration for [br.com.arch.toolkit.android.util.ThresholdData].
         */
        var threshold: Duration = 300.milliseconds
            private set

        /**
         * The default [KeyValueStorage] implementation.
         */
        var keyValue: KeyValueStorage = KeyValue.memory
            private set

        /**
         * The global [ComplexDataParser] used for serializing/deserializing complex objects.
         */
        var complexDataParser: ComplexDataParser? = null
            private set

        /**
         * Sets the default threshold duration.
         *
         * @param threshold The new duration.
         * @return The [Settings] object.
         */
        fun setDefaultThreshold(threshold: Duration) = apply {
            this.threshold = threshold
        }

        /**
         * Sets the default [KeyValueStorage].
         *
         * @param storage The new storage implementation.
         * @return The [Settings] object.
         */
        fun setDefaultStorage(storage: KeyValueStorage) = apply {
            keyValue = storage
        }

        /**
         * Sets the global [ComplexDataParser].
         *
         * @param parser The parser implementation.
         * @return The [Settings] object.
         */
        fun setComplexDataParser(parser: ComplexDataParser) = apply {
            complexDataParser = parser
        }
    }
}
