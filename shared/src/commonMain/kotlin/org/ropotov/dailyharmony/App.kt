package org.ropotov.dailyharmony

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import org.ropotov.dailyharmony.components.BottomBar
import org.ropotov.dailyharmony.navigation.BirthdayRoute
import org.ropotov.dailyharmony.navigation.HabitsRoute
import org.ropotov.dailyharmony.navigation.NavFeatureComposite
import org.ropotov.dailyharmony.navigation.NotificationsRoute
import org.ropotov.dailyharmony.navigation.controller.NavigationRouter

@Composable
fun App(
    modifier: Modifier = Modifier,
    navFeatureComposite: NavFeatureComposite = koinInject(),
    router: NavigationRouter = koinInject()
) {

    MaterialTheme {
        Scaffold(
            bottomBar = {
                BottomBar(
                    selectedRoute = HabitsRoute,
                    topLevelRoutes = listOf(HabitsRoute, NotificationsRoute, BirthdayRoute),
                    onTabSelected = {

                    }
                )
            }
        ) {

        }
    }
}