# Choose utilities for your screen

Arch Android contains Android APIs, even though its build uses Kotlin Multiplatform.
Add it to `androidMain`, never `commonMain`. It supplies utilities, not a screen architecture.

| Task | Utility | Ownership |
| --- | --- | --- |
| Find a View | `viewProvider` / `optionalViewProvider` | Access after Activity content or Fragment view creation; optional lookup returns null for missing children or parents. |
| Render loading/content/error Views | `ViewStateMachine` | Create per hierarchy; release when the Fragment view is destroyed. |
| Switch Android scenes | `SceneStateMachine` | Keep it with the scene root. |
| Bind RecyclerView rows | `SimpleAdapter` and `ViewBinder` | Bind every mutable field because holders are reused. |
| Custom row identity/types | `BaseRecyclerAdapter` with `DiffUtil.ItemCallback` | Define identity separately from content equality. |
| Android preferences | `SharedPrefStorage.Regular`, storage delegates, `ConfigValue` | Keep one backend per file and inject it. |
| Temporary values | `MemoryStorage` | Values disappear with the process; useful for tests. |
| Access a context | Explicit `Context`, or `ContextProvider` | Screen context for UI, application context for long lived storage. |

## Views and lifecycle

Keep working Views screens on Views. Delegates and state machines reduce lookup and rendering
code; they do not replace lifecycle ownership. Observe `ConfigValue.liveData` with
`viewLifecycleOwner` in a Fragment. Never retain a View, callback capturing a Fragment view,
or ViewStateMachine in an application singleton or ViewModel.

`ContextProvider.current` weakly references the latest created/resumed Activity, initially
the application. It can be null and does not guarantee a resumed, usable Activity.
Pass the current screen context explicitly for dialogs and navigation.

For ViewModels that survive configuration changes, use AndroidX `ViewModelProvider`,
`by viewModels()` or `by activityViewModels()` with the appropriate owner.
The toolkit's `viewModelProvider` delegate calls the factory on every access; it does not
retrieve an instance from a `ViewModelStore`.

## Compose and shared KMP code

For Compose, render from screen state and use Compose lists. There is no need to adapt
`ViewStateMachine` or RecyclerView binders into a cross platform abstraction. When embedding an
existing View through `AndroidView`, keep its references in the Android UI layer's lifecycle.

On Android, an existing `ConfigValue` can be observed using lifecycle aware Flow collection
(for example, AndroidX `collectAsStateWithLifecycle`, supplied by the app). Retain the wrapper
and retrieved Flow outside repeated recompositions. Updates belong to that wrapper; it is not
a preference-file change feed for other writers.

Use [Arch Storage](https://github.com/matheus-corregiari/arch-storage) for common KMP entry APIs,
Flow observation and its Compose state integration. Its memory backend is temporary; its
DataStore backend persists on supported platforms. Check its
[platform table](https://github.com/matheus-corregiari/arch-storage#modules) before choosing
JS/Wasm persistence or changing the app's minimum Android SDK.

## Choose storage by the data's owner

| Situation | Choice | Example |
| --- | --- | --- |
| Existing Android settings file and synchronous getters | Keep Arch Android SharedPreferences | A Views screen remembers a local `show_completed` Boolean. |
| Preferences shared by Android/iOS/JVM code | Arch Storage in the shared layer | A common settings repository exposes a theme entry through Flow. |
| New Compose settings driven by shared entries | Arch Storage | A retained entry exposes `state(scope)` to the UI. |
| Temporary screen/test state | Memory backend in the relevant library | A fresh backend per test isolates defaults and writes. |

Boolean, Int, Long, Float and String are practical Android preference choices. Keep key names
and types stable. Blank strings and the literal `"null"` remove entries in this backend.
Writes use `apply()`; a returning setter does not prove durable disk completion.
Reads are cached, so route writes through one backend rather than mixing direct
SharedPreferences writes with multiple backend instances.

`Storage.Settings` defaults to memory. Select persistence explicitly in delegates or
`ConfigValue`; implicit memory defaults do not survive process death. Complex models require
a `ComplexDataParser` and a compatible serialized schema. AndroidX Security's encrypted
SharedPreferences APIs are deprecated; see [dependency notes](dependencies.md).

Choosing Arch Storage does not migrate existing SharedPreferences data. Plan migration
separately: read the old typed key, write the new entry, verify the observed persisted value,
then mark migration complete. Its
[recipes](https://github.com/matheus-corregiari/arch-storage/blob/master/docs/recipes.md)
show provider/entry and Compose examples. This repo adds no dependency on Arch Storage.

Continue with [tested task recipes](recipes.md).
