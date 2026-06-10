# Arch Android Toolkit

A Kotlin-first Android toolkit with APIs designed for Android source sets in KMP projects.

[![Maven Central][badge-maven]][link-maven]
[![License][badge-license]](/LICENSE)
[![Kotlin][badge-kotlin]](https://kotlinlang.org)
[![Latest release][badge-release]][link-release]
![Lint][badge-lint]
![Coverage][badge-coverage]

## Features

- State machines for view and scene orchestration.
- Typed storage backed by memory, SharedPreferences, or encrypted SharedPreferences.
- Property delegates for persisted values, extras, views, and ViewModels.
- RecyclerView adapters, binders, and sticky headers.
- Foldable layout helpers.
- Application context provider.

## Installation

```kotlin
kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation("io.github.matheus-corregiari:arch-android:<latest-version>")
        }
    }
}
```

For an Android-only project:

```kotlin
dependencies {
    implementation("io.github.matheus-corregiari:arch-android:<latest-version>")
}
```

## Usage

Initialize storage and the context provider from the application:

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Storage.KeyValue.init(this)
        ContextProvider.init(this)
    }
}
```

Create a view state machine:

```kotlin
val machine = ViewStateMachine()
machine.setup {
    state(0) {
        visibles(viewA)
        gones(viewB)
    }
    state(1) {
        visibles(viewB)
        gones(viewA)
    }
}
machine.changeState(0)
```

Persist a typed value:

```kotlin
val darkMode = ConfigValue(
    name = "dark_mode",
    default = false,
    storage = { Storage.KeyValue.regular },
)

darkMode.set(true)
val enabled = darkMode.get()
```

## Platform Support

| Target | Support |
|:-------|:--------|
| Android | Supported from `minSdk 20` |

## Toolchain

| Tool | Version |
|:-----|:--------|
| Kotlin | `2.4.0` |
| Gradle | `9.5.1` |
| Java | `21` |

## Documentation

Project guides and API documentation are published through GitHub Pages.
See [CONTRIBUTING](CONTRIBUTING.md) for the local workflow.

## License

Licensed under the Apache License 2.0. See [LICENSE](LICENSE).

[link-maven]: https://central.sonatype.com/artifact/io.github.matheus-corregiari/arch-android
[link-release]: https://github.com/matheus-corregiari/arch-android/releases/latest

[badge-kotlin]: https://img.shields.io/badge/kotlin-2.4.0-blue.svg?logo=kotlin
[badge-maven]: https://img.shields.io/maven-central/v/io.github.matheus-corregiari/arch-android.svg
[badge-release]: https://img.shields.io/github/v/release/matheus-corregiari/arch-android
[badge-license]: https://img.shields.io/github/license/matheus-corregiari/arch-android
[badge-coverage]: https://codecov.io/gh/matheus-corregiari/arch-android/graph/badge.svg?token=146UU167K6
[badge-lint]: https://github.com/matheus-corregiari/arch-android/actions/workflows/lint.yml/badge.svg
