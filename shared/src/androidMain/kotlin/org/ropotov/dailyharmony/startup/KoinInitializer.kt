package org.ropotov.dailyharmony.startup

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.ropotov.dailyharmony.database.AndroidHabitDatabaseModule
import org.ropotov.dailyharmony.di.initKoin

class KoinInitializer(private val context: Context) : StartupInitializer {
    override fun initialize() =
        initKoin(platformModules = listOf(AndroidHabitDatabaseModule.module)) {
            androidContext(context)
        }
}