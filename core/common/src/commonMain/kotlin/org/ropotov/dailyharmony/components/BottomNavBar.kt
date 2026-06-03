package org.ropotov.dailyharmony.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.ropotov.dailyharmony.navigation.BirthdayRoute
import org.ropotov.dailyharmony.navigation.HabitsRoute
import org.ropotov.dailyharmony.navigation.NotificationsRoute
import org.ropotov.dailyharmony.navigation.TopLevelRoute

@Composable
fun BottomBar(
    selectedRoute: TopLevelRoute,
    topLevelRoutes: List<TopLevelRoute>,
    onTabSelected: (TopLevelRoute) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        NavigationBar(
            modifier = modifier,
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = 0.dp
        ) {
            topLevelRoutes.forEach { route ->
                NavigationBarItem(
                    selected = route == selectedRoute,
                    onClick = {
                        onTabSelected(route)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    icon = {
                        BottomBarItem(
                            icon = route.icon(),
                            label = route.title,
                            selected = route == selectedRoute
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        Box(
            modifier = Modifier.size(36.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary
            )
        }

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary
        )
    }
}

//TODO вынести в строковые ресурсы
private val TopLevelRoute.title: String
    get() = when (this) {
        BirthdayRoute -> "Дни рождения"
        HabitsRoute -> "Привычки"
        NotificationsRoute -> "Напоминания"
    }

@Composable
private fun TopLevelRoute.icon(): ImageVector = when (this) {
    BirthdayRoute -> Icons.Default.Cake
    HabitsRoute -> Icons.Default.List
    NotificationsRoute -> Icons.Default.Notifications
}