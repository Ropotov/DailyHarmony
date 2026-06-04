package org.ropotov.dailyharmony

import androidx.compose.ui.window.ComposeUIViewController
import org.ropotov.dailyharmony.startup.getStartupInitializers

fun MainViewController() = ComposeUIViewController {
    App()
}.apply {
    getStartupInitializers().forEach {
        it.initialize()
    }
}