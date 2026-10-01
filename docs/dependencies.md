# Dependencies

Audited against Maven Central, Google Maven and the Gradle Plugin Portal on 2026-10-01 for `1.3.2`.
Runtime dependencies and AGP use stable releases. Detekt retains its existing alpha line.
Android compile SDK **37.2**, minimum SDK **20**, Build Tools **37.0.0**.
The Android defaults live in `build-logic/src/main/kotlin/arch-multi-library.gradle.kts`.
This KMP library has no application `targetSdk`; consuming apps choose their target API.
Gradle **9.8.0**, JDK **21**, Kover **0.9.11**, MkDocs Material **9.7.7**.

Storage diagnostics use Android's `android.util.Log`; this library does not depend on Arch Lumber.

| Alias | Version | Source |
| --- | --- | --- |
| `jetbrains-dokka` | `2.2.0` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/dokka/dokka-gradle-plugin/maven-metadata.xml) |
| `jetbrains-plugin` | `2.4.20` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/kotlin-gradle-plugin/maven-metadata.xml) |
| `jetbrains-multiplatform` | `2.4.20` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/multiplatform/org.jetbrains.kotlin.multiplatform.gradle.plugin/maven-metadata.xml) |
| `jetbrains-kover` | `0.9.11` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/kotlinx/kover-gradle-plugin/maven-metadata.xml) |
| `jetbrains-coroutines-android` | `1.11.0` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-android/maven-metadata.xml) |
| `jetbrains-kotlin-test` | `2.4.20` | [Metadata](https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/kotlin-test/maven-metadata.xml) |
| `androidx-library` | `9.4.1` | [Metadata](https://dl.google.com/dl/android/maven2/com/android/kotlin/multiplatform/library/com.android.kotlin.multiplatform.library.gradle.plugin/maven-metadata.xml) |
| `androidx-appcompat` | `1.8.0` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/appcompat/appcompat/maven-metadata.xml) |
| `androidx-recycler` | `1.4.0` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/recyclerview/recyclerview/maven-metadata.xml) |
| `androidx-window` | `1.5.1` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/window/window/maven-metadata.xml) |
| `androidx-security` | `1.1.0` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/security/security-crypto-ktx/maven-metadata.xml) |
| `androidx-startup` | `1.2.0` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/startup/startup-runtime/maven-metadata.xml) |
| `androidx-constraint` | `2.2.2` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/constraintlayout/constraintlayout/maven-metadata.xml) |
| `androidx-lifecycle-runtime` | `2.11.0` | [Metadata](https://dl.google.com/dl/android/maven2/androidx/lifecycle/lifecycle-runtime/maven-metadata.xml) |
| `detekt` | `2.0.0-alpha.6` | [Metadata](https://repo.maven.apache.org/maven2/dev/detekt/detekt-gradle-plugin/maven-metadata.xml) |
| `ktlint` | `14.2.0` | [Metadata](https://plugins.gradle.org/m2/org/jlleitschuh/gradle/ktlint/org.jlleitschuh.gradle.ktlint.gradle.plugin/maven-metadata.xml) |
| `vanniktech-publish` | `0.37.0` | [Metadata](https://repo.maven.apache.org/maven2/com/vanniktech/gradle-maven-publish-plugin/maven-metadata.xml) |
| `junit-test` | `4.13.2` | [Metadata](https://repo.maven.apache.org/maven2/junit/junit/maven-metadata.xml) |
| `robolectric-test` | `4.17` | [Metadata](https://repo.maven.apache.org/maven2/org/robolectric/robolectric/maven-metadata.xml) |
| `mockk-test-android` | `1.14.11` | [Metadata](https://repo.maven.apache.org/maven2/io/mockk/mockk-android/maven-metadata.xml) |
| `mockk-test-agent` | `1.14.11` | [Metadata](https://repo.maven.apache.org/maven2/io/mockk/mockk/maven-metadata.xml) |

AndroidX Security Crypto `1.1.0` deprecates its APIs, including `EncryptedSharedPreferences`.
The existing encrypted-storage API is retained for compatibility; new applications should consider
Android Keystore APIs directly, as described in the
[AndroidX Security release notes](https://developer.android.com/jetpack/androidx/releases/security).

## Tooling sources

- [Gradle current release](https://services.gradle.org/versions/current)
- [MkDocs Material](https://pypi.org/project/mkdocs-material/)
- [JaCoCo](https://repo.maven.apache.org/maven2/org/jacoco/org.jacoco.core/maven-metadata.xml)

Robolectric 4.17 Android tests require `--add-opens=java.base/jdk.internal.access=ALL-UNNAMED`
on JDK 21. This option is scoped to test JVMs, following the
[Robolectric setup guide](https://robolectric.org/getting-started/).

Android SDK setup uses [`android-actions/setup-android@v4`](https://github.com/android-actions/setup-android/tree/v4)
with Node 24 and the maintained command-line tools provided by the action.

## GitHub Actions

The workflows and composite actions were checked against upstream releases on 2026-10-01.
Their maintained major tags already point to the current release lines:

| Action | Version |
| --- | --- |
| [Checkout](https://github.com/actions/checkout/releases) | `v7` |
| [Setup Python](https://github.com/actions/setup-python/releases) | `v7` |
| [Setup Java](https://github.com/actions/setup-java/releases) | `v6` |
| [Gradle setup](https://github.com/gradle/actions/releases) | `v6` |
| [Android setup](https://github.com/android-actions/setup-android/releases) | `v4` |
| [Upload artifact](https://github.com/actions/upload-artifact/releases) | `v7` |
| [Codecov](https://github.com/codecov/codecov-action/releases) | `v7` |
| [CodeQL](https://github.com/github/codeql-action/releases) | `v4` |
| [GitHub App token](https://github.com/actions/create-github-app-token/releases) | `v3` |
| [Upload Pages artifact](https://github.com/actions/upload-pages-artifact/releases) | `v5` |
| [Deploy Pages](https://github.com/actions/deploy-pages/releases) | `v5` |

The Foojay toolchain resolver remains on its latest release, `1.0.0`.
Kotlin `2.5.0-Beta1` and Dokka `2.3.0-Beta` are prereleases and are not adopted.
