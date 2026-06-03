package org.ropotov.dailyharmony

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    val hasBottomSheet: Boolean get() = true
}

@Serializable
sealed interface TopLevelRoute : Route {
    val order: Int
}

@Serializable
data object HabitsRoute : TopLevelRoute {
    override val order: Int = 0
}

@Serializable
data object NotificationsRoute : TopLevelRoute {
    override val order: Int = 1
}

@Serializable
data object BirthdayRoute : TopLevelRoute {
    override val order: Int = 2
}