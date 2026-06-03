package org.ropotov.components

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureRoom(extension: KotlinMultiplatformExtension) = extension.apply {
    sourceSets.apply {
        commonMain.dependencies {
            implementation(project.libs.findLibrary("kotlinx-datetime").get())
            implementation(project.libs.findLibrary("kotlinx-serialization-json").get())
            implementation(project.libs.findLibrary("room-runtime").get())
            implementation(project.libs.findLibrary("sqlite-bundled").get())
            implementation(project.libs.findLibrary("sqlite").get())
        }
    }
}