package br.com.arch.toolkit.android.storage.keyValue

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@RunWith(RobolectricTestRunner::class)
class MemoryStorageTest {

    @Test
    fun setAndGet_withValidKeyAndValue_shouldPersistInMemory() {
        val storage = MemoryStorage("test")

        storage["key"] = "value"

        assertEquals("value", storage.get<String>("key"))
        assertTrue(storage.contains("key"))
        assertEquals(1, storage.size())
    }

    @Test
    fun set_withBlankOrNullLikeValues_shouldRemoveExistingEntry() {
        val storage = MemoryStorage("test")
        storage["key"] = "value"

        storage["key"] = ""
        assertFalse(storage.contains("key"))

        storage["key"] = "value"
        storage["key"] = "null"
        assertFalse(storage.contains("key"))
    }

    @Test
    fun set_withInvalidKeys_shouldNotKeepEntry() {
        val storage = MemoryStorage("test")

        storage[""] = "value"
        storage["null"] = "value"

        assertEquals(0, storage.size())
    }

    @Test
    fun removeByRegex_shouldDeleteOnlyMatchingKeys() {
        val storage = MemoryStorage("test")
        storage["user_name"] = "john"
        storage["user_id"] = 10
        storage["session"] = "abc"

        storage.remove(Regex("user_.*"))

        assertNull(storage.get<String>("user_name"))
        assertNull(storage.get<Int>("user_id"))
        assertEquals("abc", storage.get<String>("session"))
        assertEquals(listOf("session"), storage.keys())
    }
}
