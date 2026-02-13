plugins {
    id("arch-multi-library")
    id("arch-lint")
    id("arch-documentation")
    id("arch-optimize")
    id("arch-publish")
}

kotlin {
    androidLibrary {
        compileSdk = versionInt(libs.versions.build.sdk.compile)
        minSdk = versionInt(libs.versions.build.sdk.min)
        buildToolsVersion = versionString(libs.versions.build.tools)
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
        androidUnitTest.dependencies { implementation(libs.jetbrains.kotlin.test) }
    }
}

dokka.dokkaSourceSets.configureEach {
    sourceLink {
        localDirectory.set(projectDir.resolve("src"))
        remoteUrl("${env("POM_URL")}/tree/master/android/src")
    }
}
