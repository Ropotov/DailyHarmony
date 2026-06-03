package org.ropotov.dailyharmony

import android.content.Context
import androidx.startup.Initializer
import org.ropotov.dailyharmony.startup.getStartupInitializers

class AndroidStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        getStartupInitializers().forEach { it.initialize() }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}