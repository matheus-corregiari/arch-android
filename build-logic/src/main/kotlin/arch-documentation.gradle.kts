/** Configures API documentation for publishable modules. */
import org.gradle.internal.extensions.stdlib.capitalized
import org.jetbrains.dokka.gradle.DokkaExtension

plugins {
    id("org.jetbrains.dokka")
}

extensions.configure(DokkaExtension::class) {
    moduleName.set(project.name.capitalized())
    moduleVersion.set(project.versionName)
    basePublicationsDirectory.set(file("$rootDir/docs/api/${project.name}"))
    dokkaSourceSets.configureEach {
        reportUndocumented.set(true)
        skipDeprecated.set(true)
        skipEmptyPackages.set(true)
        jdkVersion.set(projectJavaVersionCode)
        enableAndroidDocumentationLink.set(true)
        enableJdkDocumentationLink.set(true)
        enableKotlinStdLibDocumentationLink.set(true)
    }
}
