package org.ropotov.dailyharmony.navigation.controller

import kotlinx.coroutines.flow.MutableSharedFlow
import org.koin.core.annotation.Single
import org.ropotov.dailyharmony.navigation.Route

@Single
class NavigationRouter {

    private val commands = MutableSharedFlow<NavCommand>(
        extraBufferCapacity = 32
    )
    fun navigateTo(
        route: Route,
        clearBackStack: Boolean = false,
        singleTop: Boolean = false,
        replaceCurrent: Boolean = false
    ) {
        commands.tryEmit(
            NavCommand.NavigateTo(
                route = route,
                clearBackStack = clearBackStack,
                singleTop = singleTop,
                replaceCurrent = replaceCurrent
            )
        )
    }

    fun navigateBack() {
        commands.tryEmit(NavCommand.NavigateBack)
    }
}