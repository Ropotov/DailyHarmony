package org.ropotov.dailyharmony

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.koinInject
import org.ropotov.dailyharmony.components.BottomBar
import org.ropotov.dailyharmony.navigation.NavFeatureComposite
import org.ropotov.dailyharmony.navigation.Route
import org.ropotov.dailyharmony.navigation.controller.NavController
import org.ropotov.dailyharmony.navigation.controller.NavigationRouter

@Composable
fun App(
    modifier: Modifier = Modifier,
    navFeatureComposite: NavFeatureComposite = koinInject(),
    router: NavigationRouter = koinInject()
) {

    val topLevelRoutes = navFeatureComposite.topLevelRoutes

    val tabBackStacks = remember {
        topLevelRoutes.associateWith { route ->
            mutableStateListOf<Route>(route)
        }
    }

    var currentTab by remember {
        mutableStateOf(topLevelRoutes.first())
    }

    val navController = remember {
        NavController { tabBackStacks[currentTab] ?: SnapshotStateList() }
    }

    val currentBackStack = tabBackStacks[currentTab] ?: SnapshotStateList()

    MaterialTheme {
        Scaffold(
            modifier = modifier.fillMaxSize().navigationBarsPadding(),
            bottomBar = {
                BottomBar(
                    selectedRoute = currentTab,
                    topLevelRoutes = topLevelRoutes,
                    onTabSelected = { selected ->
                        if (selected == currentTab) {
                            val stack = tabBackStacks[selected] ?: SnapshotStateList()
                            stack.clear()
                            stack.add(selected)
                        } else {
                            currentTab = selected
                        }
                    }
                )
            }
        ) { paddingValues ->
            NavDisplay(
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                backStack = currentBackStack,
                onBack = { navController.navigateBack() },
                entryDecorators = listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator(),
                ),
                entryProvider = entryProvider(
                    builder = navFeatureComposite.buildEntryProvider()
                ),
            )
        }
    }
}