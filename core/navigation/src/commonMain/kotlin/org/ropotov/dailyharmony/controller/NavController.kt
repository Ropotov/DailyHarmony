package org.ropotov.dailyharmony.controller

import androidx.compose.runtime.snapshots.SnapshotStateList
import org.ropotov.dailyharmony.Route

class NavController(
    private val getCurrentBackStack: () -> SnapshotStateList<Route>
) {
    val currentRoute: Route? get() = getCurrentBackStack().lastOrNull()

    fun navigateTo(
        route: Route,
        clearBackStack: Boolean = false,
        singleTop: Boolean = false,
        replaceCurrent: Boolean = false
    ) {
        val backStack = getCurrentBackStack()
        if (clearBackStack) {
            backStack.clear()
        }

        if (replaceCurrent && backStack.isNotEmpty()) {
            backStack.removeAt(backStack.lastIndex)
        }

        if (singleTop && backStack.lastOrNull() == route) return
        backStack.add(route)
    }

    fun navigateBack(): Boolean {
        val backStack = getCurrentBackStack()

        if (backStack.size <= 1) return false
        backStack.removeAt(backStack.lastIndex)
        return true
    }
}