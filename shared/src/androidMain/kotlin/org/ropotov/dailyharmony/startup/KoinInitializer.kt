package org.ropotov.dailyharmony.startup

import org.ropotov.dailyharmony.di.initKoin

class KoinInitializer() : StartupInitializer {
    override fun initialize() = initKoin()
}