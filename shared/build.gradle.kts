import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kmp.setup)
    alias(libs.plugins.compose.setup)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.koin.setup)
    alias(libs.plugins.coroutines.setup)
    alias(libs.plugins.module.setup)
}

kotlin {
    android {
        namespace = "org.ropotov.dailyharmony"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources.enable = true
        compilerOptions { jvmTarget.set(JvmTarget.JVM_21) }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime)

            implementation(projects.core.navigation)
            implementation(projects.core.common)
            implementation(projects.core.database)

            implementation(projects.feature.habits)
        }

        androidMain.dependencies {
            implementation(libs.androidx.startup)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.ui.tooling)
}