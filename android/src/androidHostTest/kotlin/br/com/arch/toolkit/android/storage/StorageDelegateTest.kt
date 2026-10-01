package br.com.arch.toolkit.android.storage

import br.com.arch.toolkit.android.storage.delegate.keyValueStorage
import br.com.arch.toolkit.android.storage.keyValue.KeyValueStorage
import br.com.arch.toolkit.android.storage.keyValue.MemoryStorage
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.hours

@RunWith(RobolectricTestRunner::class)
class StorageDelegateTest {

    @Test
    fun optionalValue_writesCachesAndRemovesWithoutLoggingSecrets() {
        val storage = MemoryStorage("sensitive-storage")
        var value: String? by keyValueStorage<String>("private-key")
            .storage(storage).threshold(1.hours)
        ShadowLog.clear()

        assertNull(value)
        value = "private-token"
        assertEquals("private-token", storage.get<String>("private-key"))
        storage["private-key"] = "external-value"
        assertEquals("private-token", value)
        value = null
        assertNull(storage.get<String>("private-key"))
        assertNull(value)
        assertTrue(ShadowLog.getLogs().isEmpty())
    }

    @Test
    fun optionalValue_handlesFailingNameAndStorageProviders() {
        var invalidName: String? by keyValueStorage<String> { error("name unavailable") }
        var unavailableStorage: String? by keyValueStorage<String>("unavailable")
            .storage { error("storage unavailable") }

        assertNull(invalidName)
        invalidName = "ignored"
        assertNull(invalidName)
        assertNull(unavailableStorage)
        unavailableStorage = "ignored"
        assertNull(unavailableStorage)
    }

    @Test
    fun optionalValue_preservesCachedValueWhenBackendMutationFails() {
        var fail = false
        val memory = MemoryStorage("failing-backend")
        val storage = object : KeyValueStorage by memory {
            override fun <T : Any> set(key: String, value: T?) {
                check(!fail) { "write unavailable" }
                memory[key] = value
            }

            override fun remove(key: String) {
                check(!fail) { "remove unavailable" }
                memory.remove(key)
            }
        }
        var value: String? by keyValueStorage<String>("cached-key")
            .storage(storage).threshold(1.hours)

        value = "saved"
        fail = true
        value = "rejected"
        assertEquals("saved", value)
        value = null
        assertEquals("saved", value)
        assertEquals("saved", memory.get<String>("cached-key"))
    }

    @Test
    fun requiredValue_usesDefaultAndPropagatesDefaultProviderFailure() {
        val previous = Storage.Settings.keyValue
        val storage = MemoryStorage("required-value")
        Storage.Settings.setDefaultStorage(storage)
        try {
            var value: String by keyValueStorage<String>("required-key").required("fallback")
            val failing: String by keyValueStorage<String>("failing-default")
                .required { throw IllegalStateException("default unavailable") }
            ShadowLog.clear()

            assertEquals("fallback", value)
            value = "saved"
            assertEquals("saved", value)
            assertFailsWith<IllegalStateException> { failing }
            assertTrue(ShadowLog.getLogs().isEmpty())
        } finally {
            Storage.Settings.setDefaultStorage(previous)
        }
    }
}
