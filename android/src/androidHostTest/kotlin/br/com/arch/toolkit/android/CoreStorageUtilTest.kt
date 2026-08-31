package br.com.arch.toolkit.android

import android.app.Application
import br.com.arch.toolkit.android.storage.ComplexDataParser
import br.com.arch.toolkit.android.storage.Storage
import br.com.arch.toolkit.android.storage.StorageType
import br.com.arch.toolkit.android.storage.keyValue.MemoryStorage
import br.com.arch.toolkit.android.storage.keyValue.SharedPrefStorage
import br.com.arch.toolkit.android.util.ConfigValue
import br.com.arch.toolkit.android.util.ContextProvider
import br.com.arch.toolkit.android.util.ObservableValue
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@RunWith(RobolectricTestRunner::class)
class CoreStorageUtilTest {

    @Test
    fun observableValue_readsWritesAndHonorsReadOnlyMode() {
        var saved: String? = "initial"
        val value = ObservableValue("fallback", { saved }) { saved = it }

        assertEquals("initial", value.value)
        value.value = "updated"
        assertEquals("updated", saved)

        val readOnly = ObservableValue("fallback", { "loaded" })
        readOnly.value = "ignored"
        assertEquals("loaded", readOnly.value)
    }

    @Test
    fun observableValue_handlesGetterFailureAndExposesObservables() {
        val value = ObservableValue(42, { error("failure") })

        assertEquals(42, value.value)
        assertNotNull(value.flow)
        assertNotNull(value.liveData)
    }

    @Test
    fun configValue_usesDefaultAndPersistsUpdates() {
        val storage = MemoryStorage("config")
        val config = ConfigValue("enabled", false) { storage }

        assertFalse(config.get())
        config.set(true)

        assertTrue(config.get())
        assertEquals(true, storage.get<Boolean>("enabled"))
        assertNotNull(config.flow)
        assertNotNull(config.liveData)
    }

    @Test
    fun regularSharedPreferences_supportsCrudAndCaching() {
        val context = RuntimeEnvironment.getApplication() as Application
        val storage = SharedPrefStorage.Regular(context, "crud")

        assertEquals(StorageType.SHARED_PREF, storage.type)
        storage["name"] = "Arch"
        storage["count"] = 3
        assertEquals("Arch", storage.get<String>("name"))
        assertEquals(3, storage.get<Int>("count"))
        assertTrue(storage.contains("name"))
        assertEquals(2, storage.size())

        storage.remove("name")
        assertNull(storage.get<String>("name"))
        storage.clear()
        assertEquals(0, storage.size())
    }

    @Test
    fun storageSettings_updatesAllConfigurableDefaults() {
        val storage = MemoryStorage("custom")
        val parser = object : ComplexDataParser {
            override fun <T : Any> fromJson(
                json: String,
                classToParse: kotlin.reflect.KClass<T>
            ): T = error("not used")

            override fun <T : Any> toJson(data: T): String = data.toString()
        }

        Storage.Settings
            .setDefaultStorage(storage)
            .setComplexDataParser(parser)

        assertEquals(storage, Storage.Settings.keyValue)
        assertEquals(parser, Storage.Settings.complexDataParser)
        assertTrue(Storage.Settings.threshold.isPositive())
    }

    @Test
    fun contextProvider_tracksApplicationContext() {
        val application = RuntimeEnvironment.getApplication() as Application

        ContextProvider.init(application)

        assertEquals(application, ContextProvider.current)
    }
}
