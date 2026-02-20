package br.com.arch.toolkit.android.util

import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.milliseconds

@RunWith(RobolectricTestRunner::class)
class ThresholdDataTest {

    @Test
    fun get_withMatchingScopeAndNotExpired_shouldReturnValue() {
        val cache = ThresholdData<String>(300.milliseconds)

        cache.set("storage", "token", "abc")

        assertEquals("abc", cache.get("storage", "token"))
    }

    @Test
    fun get_withDifferentStorageName_shouldClearAndReturnNull() {
        val cache = ThresholdData<String>(300.milliseconds)

        cache.set("storage", "token", "abc")

        assertNull(cache.get("another", "token"))
        assertTrue(cache.isExpired())
    }

    @Test
    fun get_withDifferentName_shouldClearAndReturnNull() {
        val cache = ThresholdData<String>(300.milliseconds)

        cache.set("storage", "token", "abc")

        assertNull(cache.get("storage", "different"))
        assertTrue(cache.isExpired())
    }

    @Test
    fun get_withExpiredValue_shouldReturnNull() {
        val cache = ThresholdData<String>((-1).milliseconds)

        cache.set("storage", "token", "abc")

        assertNull(cache.get("storage", "token"))
    }

    @Test
    fun set_withNullValue_shouldKeepCacheCleared() {
        val cache = ThresholdData<String>(300.milliseconds)

        cache.set("storage", "token", null)

        assertTrue(cache.isExpired())
        assertNull(cache.get("storage", "token"))
    }
}
