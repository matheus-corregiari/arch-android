package br.com.arch.toolkit.android.examples

import android.content.Context
import android.os.Looper
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.arch.toolkit.android.recyclerAdapter.SimpleAdapter
import br.com.arch.toolkit.android.recyclerAdapter.ViewBinder
import br.com.arch.toolkit.android.statemachine.ViewStateMachine
import br.com.arch.toolkit.android.storage.keyValue.SharedPrefStorage
import br.com.arch.toolkit.android.util.ConfigValue
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun observePreference(owner: LifecycleOwner, label: TextView, value: LiveData<Boolean>) {
    value.observe(owner) { enabled ->
        label.text = if (enabled) "Enabled" else "Disabled"
    }
}

fun loadingMachine(content: View, progress: View) = ViewStateMachine().apply {
    setup {
        state(0) {
            visibles(progress)
            gones(content)
        }
        state(1) {
            visibles(content)
            gones(progress)
        }
    }
    changeState(0)
}

data class TaskRow(val title: String)

class TaskRowView(context: Context) : TextView(context), ViewBinder<TaskRow> {
    override fun bind(model: TaskRow) {
        text = model.title
    }
}

fun taskAdapter() = SimpleAdapter<TaskRow, TaskRowView>(::TaskRowView)

fun completedPreference(context: Context): ConfigValue<Boolean> {
    val storage = SharedPrefStorage.Regular(context.applicationContext, "task-settings")
    return ConfigValue("show_completed", false) { storage }
}

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class UsageRecipesTest {

    @Test
    fun lifecycleRecipe_stopsUpdatingAfterViewOwnerIsDestroyed() {
        val owner = RecipeOwner()
        val label = TextView(RuntimeEnvironment.getApplication())
        val value = MutableLiveData(false)
        owner.registry.currentState = Lifecycle.State.STARTED
        observePreference(owner, label, value)
        assertEquals("Disabled", label.text.toString())
        value.value = true
        assertEquals("Enabled", label.text.toString())
        owner.registry.currentState = Lifecycle.State.DESTROYED
        value.value = false
        assertEquals("Enabled", label.text.toString())
    }

    @Test
    fun stateRecipe_rendersLoadingThenContent() {
        val context = RuntimeEnvironment.getApplication()
        val content = View(context)
        val progress = View(context)
        val machine = loadingMachine(content, progress)
        assertEquals(View.GONE, content.visibility)
        assertEquals(View.VISIBLE, progress.visibility)
        machine.changeState(1)
        assertEquals(View.VISIBLE, content.visibility)
        assertEquals(View.GONE, progress.visibility)
    }

    @Test
    fun listRecipe_rebindsTextAndClickToCurrentRow() {
        val adapter = taskAdapter()
        var clicked: TaskRow? = null
        adapter.withListener { clicked = it }
        val first = TaskRow("Buy milk")
        adapter.setList(listOf(first))
        val holder = adapter.onCreateViewHolder(FrameLayout(RuntimeEnvironment.getApplication()), 0)
        adapter.onBindViewHolder(holder, 0)
        val row = holder.itemView as TaskRowView
        assertEquals(first.title, row.text.toString())
        row.performClick()
        assertEquals(first, clicked)
        val second = TaskRow("Read book")
        adapter.setList(listOf(second))
        awaitList(adapter, listOf(second))
        adapter.onBindViewHolder(holder, 0)
        assertEquals(second.title, row.text.toString())
        row.performClick()
        assertEquals(second, clicked)
    }

    @Test
    fun preferenceRecipe_restoresValueFromRecreatedBackend() {
        val context = RuntimeEnvironment.getApplication()
        val storage = SharedPrefStorage.Regular(context, "task-settings")
        storage.clear()
        try {
            val preference = completedPreference(context)
            assertFalse(preference.get())
            preference.set(true)
            assertTrue(completedPreference(context).get())
        } finally {
            storage.clear()
        }
    }

    private class RecipeOwner : LifecycleOwner {
        val registry = LifecycleRegistry(this)
        override val lifecycle: Lifecycle get() = registry
    }

    private fun awaitList(adapter: SimpleAdapter<TaskRow, TaskRowView>, expected: List<TaskRow>) {
        val deadline = System.nanoTime() + 5_000_000_000L
        while (adapter.items != expected && System.nanoTime() < deadline) {
            shadowOf(Looper.getMainLooper()).idle()
            Thread.sleep(10)
        }
        assertEquals(expected, adapter.items)
    }
}
