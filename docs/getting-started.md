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

Features that need an application context can be initialized from `Application.onCreate`:

```kotlin
Storage.KeyValue.init(this)
ContextProvider.init(this)
```
