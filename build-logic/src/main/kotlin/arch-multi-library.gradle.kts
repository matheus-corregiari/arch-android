@file:Suppress("UnstableApiUsage", "OPT_IN_USAGE")

import com.android.build.api.variant.impl.capitalizeFirstChar
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
}

extensions.configure<KotlinMultiplatformExtension> {
    compilerOptions { jvmToolchain(projectJavaVersionCode) }
    withSourcesJar(true)
    androidLibrary {
        namespace = "br.com.arch.toolkit.${project.name}"
        testNamespace = "test.$namespace"
        androidResources { enable = true }
        withHostTest {
            enableCoverage = true
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
        lint {
            checkReleaseBuilds = true
            abortOnError = true
            ignoreWarnings = false
            absolutePaths = false
            warningsAsErrors = false

            htmlOutput = File("$rootDir/build/reports/lint/html/${project.name}-lint.html")
            xmlOutput = File("$rootDir/build/reports/lint/xml/${project.name}-lint.xml")
        }
        testCoverage { jacocoVersion = libraries.version("jacoco") }
        optimization.consumerKeepRules.file("consumer-proguard-rules.pro")
    }
}
