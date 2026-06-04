package org.ropotov.dailyharmony.startup

import org.ropotov.dailyharmony.database.IosHabitDatabaseModule
import org.ropotov.dailyharmony.di.initKoin

object KoinInitializer : StartupInitializer {
    override fun initialize() = initKoin(platformModules = listOf(IosHabitDatabaseModule.module))
}