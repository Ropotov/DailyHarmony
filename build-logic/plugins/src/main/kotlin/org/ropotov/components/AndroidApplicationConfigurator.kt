package org.ropotov.components

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroidApplication(
    extension: ApplicationExtension
) = extension.apply {
    compileSdk = libs.findVersion("android-compileSdk").get().toString().toInt()

    defaultConfig {
        minSdk = libs.findVersion("android-minSdk").get().toString().toInt()
        targetSdk = libs.findVersion("android-targetSdk").get().toString().toInt()
        versionCode = libs.findVersion("versionCode").get().toString().toInt()
        versionName = libs.findVersion("versionName").get().toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

