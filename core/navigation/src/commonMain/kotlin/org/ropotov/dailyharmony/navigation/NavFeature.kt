package org.ropotov.dailyharmony

import androidx.navigation3.runtime.EntryProviderScope

interface NavFeature {
    val topLevelRoutes: Set<Route>
    fun registerEntries(builder: EntryProviderScope<Route>)
}