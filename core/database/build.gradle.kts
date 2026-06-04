plugins {
    alias(libs.plugins.module.setup)
    alias(libs.plugins.koin.setup)
    alias(libs.plugins.room.setup)

}

kotlin {
    android {
        namespace = "org.ropotov.dailyharmony.database"
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}