package org.ropotov.dailyharmony.startup

actual fun getStartupInitializers(): List<StartupInitializer> = listOf(
    KoinInitializer
)
