package org.ropotov.dailyharmony.startup

import org.ropotov.dailyharmony.di.initKoin

object KoinInitializer : StartupInitializer {
    override fun initialize() = initKoin()
}