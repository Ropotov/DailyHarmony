package org.ropotov.dailyharmony.habits

import androidx.navigation3.runtime.EntryProviderScope
import org.koin.core.annotation.Factory
import org.ropotov.dailyharmony.habits.ui.HabitsScreen
import org.ropotov.dailyharmony.navigation.HabitsRoute
import org.ropotov.dailyharmony.navigation.NavFeature
import org.ropotov.dailyharmony.navigation.Route

@Factory
class HabitsNavFeature : NavFeature {
    override val topLevelRoutes: Set<Route> = setOf(HabitsRoute)
    override fun registerEntries(builder: EntryProviderScope<Route>) = with(builder) {
        entry<HabitsRoute> { HabitsScreen() }
    }
}