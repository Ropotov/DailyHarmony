package org.ropotov.dailyharmony.navigation

import androidx.navigation3.runtime.EntryProviderScope

interface NavFeature {
    val topLevelRoutes: Set<Route>
    fun registerEntries(builder: EntryProviderScope<Route>)
}