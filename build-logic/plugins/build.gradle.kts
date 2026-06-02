plugins {
    `kotlin-dsl`
}

group = "org.ropotov.dailyharmony.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kmpSetup") {
            id = "org.ropotov.kmp.setup"
            implementationClass = "KMPSetupConventionPlugin"
        }
        register("applicationSetup") {
            id = "org.ropotov.application.setup"
            implementationClass = "ApplicationSetupConventionPlugin"
        }
        register("moduleSetup") {
            id = "org.ropotov.module.setup"
            implementationClass = "ModuleSetupGradlePlugin"
        }
        register("koin") {
            id = "org.ropotov.koin"
            implementationClass = "KoinConventionPlugin"
        }
        register("compose") {
            id = "org.ropotov.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("coroutines") {
            id = "org.ropotov.coroutines"
            implementationClass = "CoroutinesConventionPlugin"
        }
        register("room") {
            id = "org.ropotov.room"
            implementationClass = "RoomConventionPlugin"
        }
    }
}