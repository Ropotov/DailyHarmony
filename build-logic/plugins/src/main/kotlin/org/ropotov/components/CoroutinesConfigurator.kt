package org.ropotov.components

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureCoroutines(extension: KotlinMultiplatformExtension) = extension.apply {
    sourceSets.apply {
        commonMain.dependencies {
            implementation(project.libs.findLibrary("kotlinx-coroutines-core").get())
        }
        androidMain.dependencies {
            implementation(project.libs.findLibrary("kotlinx-coroutines-android").get())
        }
        commonTest.dependencies {
            implementation(project.libs.findLibrary("kotlinx-coroutines-test").get())

        }
    }
}