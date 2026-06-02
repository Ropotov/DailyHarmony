package org.ropotov.components

import com.android.build.api.variant.KotlinMultiplatformAndroidComponentsExtension
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureAndroidLibrary(
    extension: KotlinMultiplatformAndroidComponentsExtension
): KotlinMultiplatformAndroidComponentsExtension = extension.apply {
    finalizeDsl { android ->
        android.compileSdk = libs.findVersion("android.compileSdk").get().toString().toInt()
        android.minSdk = libs.findVersion("android.minSdk").get().toString().toInt()
    }
}

internal fun configureLibraryKotlinMultiplatform(
    extension: KotlinMultiplatformExtension
): KotlinMultiplatformExtension = extension.apply {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    sourceSets.apply {
        commonMain.dependencies {
            implementation(project.libs.findLibrary("kermit").get())
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}