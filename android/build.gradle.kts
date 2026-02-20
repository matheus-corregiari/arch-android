plugins {
    id("arch-multi-library")
    id("arch-lint")
    id("arch-documentation")
    id("arch-optimize")
    id("arch-publish")
}

kotlin {
    compilerOptions { freeCompilerArgs.add("-Xexplicit-backing-fields") }

    androidLibrary {
        compileSdk = versionInt(libs.versions.build.sdk.compile)
        minSdk = versionInt(libs.versions.build.sdk.min)
        buildToolsVersion = versionString(libs.versions.build.tools)
        withJava()
    }

    // Libraries
    sourceSets {
        androidMain.dependencies {
            implementation(libs.jetbrains.coroutines.android)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.recycler)
            implementation(libs.androidx.constraint)
            implementation(libs.androidx.security)
            implementation(libs.androidx.startup)
            implementation(libs.androidx.window)
            implementation(libs.androidx.lifecycle.runtime)
            implementation(libs.arch.lumber)
        }
        androidHostTest.dependencies {
            implementation(libs.robolectric.test)
            implementation(libs.junit.test)
            implementation(libs.jetbrains.kotlin.test)
            implementation(libs.mockk.test.android)
            implementation(libs.mockk.test.agent)
        }
    }
}

dokka.dokkaSourceSets.configureEach {
    sourceLink {
        localDirectory.set(projectDir.resolve("src"))
        remoteUrl("${env("POM_URL")}/tree/master/android/src")
    }
}
