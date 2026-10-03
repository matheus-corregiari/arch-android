# Getting Started

## Requirements

- Android `minSdk 20` or newer.
- JDK 21 for building the project.

## Install

```kotlin
dependencies {
    implementation("io.github.matheus-corregiari:arch-android:<version>")
}
```

In a KMP project, add the dependency to `androidMain`.

## Initialize

AndroidX Startup initializes `Storage.KeyValue` and `ContextProvider` through the library's
merged manifest. If your app disables these initializers, initialize the needed features once
from `Application.onCreate`:

```kotlin
Storage.KeyValue.init(this)
ContextProvider.init(this)
```

An explicit `SharedPrefStorage.Regular(applicationContext, "settings")` backend needs no
global storage initialization. Choose the appropriate utilities in the
[consumer guide](consumer-guide.md) and start with [task recipes](recipes.md).
