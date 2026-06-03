package org.ropotov.components

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureComposeMultiplatform(
    extension: KotlinMultiplatformExtension,
) = extension.apply {

    sourceSets.apply {
        commonMain.dependencies {
            api(project.libs.findLibrary("compose-runtime").get())
            api(project.libs.findLibrary("compose-ui").get())
            api(project.libs.findLibrary("compose-foundation").get())
            api(project.libs.findLibrary("compose-resources").get())
            api(project.libs.findLibrary("compose-material3").get())
            api(project.libs.findLibrary("compose-material-icons").get())
            implementation(project.libs.findLibrary("compose-ui-tooling-preview").get())

            implementation(project.libs.findLibrary("androidx-lifecycle-viewmodel").get())
            implementation(project.libs.findLibrary("androidx-lifecycle-runtime").get())
            implementation(project.libs.findLibrary("androidx-compose-nav3").get())
            implementation(project.libs.findLibrary("androidx-lifecycle-viewmodel-navigation3").get())
            implementation(project.libs.findLibrary("androidx-navigation3-material3-adaptive").get())

            implementation(project.libs.findLibrary("coil").get())
            implementation(project.libs.findLibrary("coil-compose").get())
            implementation(project.libs.findLibrary("coil-mp").get())
            implementation(project.libs.findLibrary("coil-network.ktor").get())
            implementation(project.libs.findLibrary("kotlinx-datetime").get())
            implementation(project.libs.findLibrary("kotlinx-collections-immutable").get())
        }

        androidMain.dependencies {
            implementation(project.libs.findLibrary("androidx-appcompat").get())
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(project.libs.findLibrary("compose-ui-test").get())
        }
    }
}