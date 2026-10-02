# Usage Recipes

These examples use Android APIs in `androidMain`. Complete implementations and behavior checks
live in [UsageRecipesTest](https://github.com/matheus-corregiari/arch-android/blob/master/android/src/androidHostTest/kotlin/br/com/arch/toolkit/android/examples/UsageRecipesTest.kt).
Run `./gradlew ciTest` (`gradlew.bat ciTest` on Windows); existing CI runs these tests and lint.
See [consumer guidance](consumer-guide.md) for Views, Compose/KMP and storage decisions.

## Lifecycle: observe preferences in a Fragment view

```kotlin
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun observePreference(owner: LifecycleOwner, label: TextView, value: LiveData<Boolean>) {
    value.observe(owner) { enabled ->
        label.text = if (enabled) "Enabled" else "Disabled"
    }
}
```

Call in `onViewCreated`: `observePreference(viewLifecycleOwner, label, preference.liveData)`
with a retained `ConfigValue`. The test supplies `MutableLiveData` to isolate lifecycle behavior.
The host test verifies updates stop after destruction. Access View delegates only while that
hierarchy exists; use `optionalViewProvider` for a legitimately absent child/parent.

AndroidX Startup initializes storage and ContextProvider through the library manifest. If the
app removes those initializers, initialize the needed feature once in `Application.onCreate`.
Prefer passing `applicationContext` into storage, as below, over retrieving a potentially stale
Activity from a global provider.

## State: switch loading and content

```kotlin
import android.view.View
import br.com.arch.toolkit.android.statemachine.ViewStateMachine

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
```

Call `changeState(1)` when content is ready on the UI thread. Both states specify both Views:
omitted properties retain previous values. With the default configuration, `setup` starts the
machine without selecting a state; `changeState(0)` performs the initial render. An explicitly
configured `initialState` is rendered during `setup`.
Create a machine per Fragment view and clear its reference in `onDestroyView`.
The host test checks initial loading visibility and the content transition.

## Lists: bind immutable snapshots

```kotlin
import android.content.Context
import android.widget.TextView
import br.com.arch.toolkit.android.recyclerAdapter.SimpleAdapter
import br.com.arch.toolkit.android.recyclerAdapter.ViewBinder

data class TaskRow(val title: String)

class TaskRowView(context: Context) : TextView(context), ViewBinder<TaskRow> {
    override fun bind(model: TaskRow) {
        text = model.title
    }
}

fun taskAdapter() = SimpleAdapter<TaskRow, TaskRowView>(::TaskRowView)
```

Attach to a RecyclerView with a layout manager. Use `adapter.setList(listOf(TaskRow("Buy milk")))`
and `adapter.withListener { row -> /* open row */ }` on the UI thread.
Submit new immutable snapshots; do not mutate submitted lists or their models. Diffing is
asynchronous; `items` reflects the last committed list. Build rapid edits in the screen's
source of truth and submit complete snapshots instead of chaining `addItem`.
The default differ uses equality for identity and content. For stable IDs and editable rows,
extend `BaseRecyclerAdapter` with an ID-aware `DiffUtil.ItemCallback`.
The host test creates/rebinds a holder and checks clicks use the newly bound row.

## Preferences: persist a Boolean and reopen it

```kotlin
import android.content.Context
import br.com.arch.toolkit.android.storage.keyValue.SharedPrefStorage
import br.com.arch.toolkit.android.util.ConfigValue

fun completedPreference(context: Context): ConfigValue<Boolean> {
    val storage = SharedPrefStorage.Regular(context.applicationContext, "task-settings")
    return ConfigValue("show_completed", false) { storage }
}
```

Create and retain one wrapper, then call `set(true)` and `get()`. The test recreates the backend
to check persistence rather than only checking the memory cache. Use fresh `MemoryStorage` for
tests without persistence. LiveData/Flow reports updates through that wrapper; other wrappers
and external file writes do not form an automatic change stream. For shared reactive settings,
see [Arch Storage criteria](consumer-guide.md#choose-storage-by-the-datas-owner).
