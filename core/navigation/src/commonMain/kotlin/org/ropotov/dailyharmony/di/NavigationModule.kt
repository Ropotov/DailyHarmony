package org.ropotov.dailyharmony.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.scope.Scope
import org.ropotov.dailyharmony.NavFeature
import org.ropotov.dailyharmony.NavFeatureComposite


@Module
@ComponentScan("org.ropotov.dailyharmony.navigation")
class NavigationModule {
    @Single
    fun provide(scope: Scope): NavFeatureComposite = NavFeatureComposite(
        features = scope.getAll<NavFeature>()
    )
}