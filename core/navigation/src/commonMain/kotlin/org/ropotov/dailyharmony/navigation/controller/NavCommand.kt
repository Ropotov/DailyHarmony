package org.ropotov.dailyharmony.navigation.controller

import org.ropotov.dailyharmony.navigation.Route

sealed interface NavCommand {

    data class NavigateTo(
        val route: Route,
        val clearBackStack: Boolean = false,
        val singleTop: Boolean = false,
        val replaceCurrent: Boolean = false
    ) : NavCommand

    data object NavigateBack : NavCommand

}