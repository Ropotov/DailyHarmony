package org.ropotov.dailyharmony.startup

actual fun getStartupInitializers(contextWrapper: ContextWrapper): List<StartupInitializer> = listOf(
    KoinInitializer
)
