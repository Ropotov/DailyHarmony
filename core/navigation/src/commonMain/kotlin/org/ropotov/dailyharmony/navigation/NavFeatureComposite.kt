package org.ropotov.dailyharmony.navigation

import androidx.navigation3.runtime.EntryProviderScope

class NavFeatureComposite(
    private val features: List<NavFeature>
) {

    val topLevelRoutes: List<TopLevelRoute>
        get() = features
            .flatMap { it.topLevelRoutes.filterIsInstance<TopLevelRoute>() }
            .sortedBy { it.order }
            .distinct()

    fun buildEntryProvider(): EntryProviderScope<Route>.() -> Unit = {
        features.forEach { feature ->
            feature.registerEntries(this)
        }
    }
}