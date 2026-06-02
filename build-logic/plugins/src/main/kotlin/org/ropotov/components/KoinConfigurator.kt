package org.ropotov.components

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureKoin(extension: KotlinMultiplatformExtension) = extension.apply {
    sourceSets.apply {
        commonMain.dependencies {
            implementation(project.libs.findLibrary("koin-core").get())
            implementation(project.libs.findLibrary("koin-compose").get())
            implementation(project.libs.findLibrary("koin-compose-viewmodel").get())
            implementation(project.libs.findLibrary("koin-compose-viewmodel-navigation").get())
            api(project.libs.findLibrary("koin-annotations").get())
        }

        androidMain.dependencies {
            implementation(project.libs.findLibrary("koin-android").get())
        }
    }
    sourceSets.named("commonMain").configure {
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
    }
}