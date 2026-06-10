# Usage Recipes

## Persist a configuration value

```kotlin
val value = ConfigValue(
    name = "feature_enabled",
    default = false,
    storage = { Storage.KeyValue.regular },
)
```

## Change view state

```kotlin
val machine = ViewStateMachine()
machine.setup {
    state(0) { visibles(content) }
    state(1) { visibles(progress) }
}
machine.changeState(0)
```

## Use a simple adapter

Use `SimpleAdapter` with a `ViewBinder` when a list only needs item creation and binding. Extend
`BaseRecyclerAdapter` when the list requires custom item types or behavior.
