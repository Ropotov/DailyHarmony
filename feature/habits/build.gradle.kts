plugins {
    alias(libs.plugins.module.setup)
    alias(libs.plugins.compose.setup)
    alias(libs.plugins.koin.setup)
}

kotlin {
    android {
        namespace = "org.ropotov.dailyharmony.habits"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.navigation)
        }
    }
}