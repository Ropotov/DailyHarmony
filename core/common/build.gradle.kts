plugins {
    alias(libs.plugins.module.setup)
    alias(libs.plugins.compose.setup)
    alias(libs.plugins.koin.setup)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    android {
        namespace = "org.ropotov.dailyharmony.common"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.navigation)
        }
    }
}