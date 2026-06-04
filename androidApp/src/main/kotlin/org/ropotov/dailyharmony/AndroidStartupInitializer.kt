package org.ropotov.dailyharmony

import android.content.Context
import androidx.startup.Initializer
import org.ropotov.dailyharmony.startup.ContextWrapper
import org.ropotov.dailyharmony.startup.getStartupInitializers

class AndroidStartupInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        val wrapper = ContextWrapper(context)
        getStartupInitializers(wrapper).forEach { it.initialize() }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}