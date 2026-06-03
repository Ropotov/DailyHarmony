package org.ropotov.dailyharmony.di

import org.koin.core.module.Module
import org.koin.ksp.generated.module
import org.ropotov.dailyharmony.habits.di.HabitsFeatureModule
import org.ropotov.dailyharmony.navigation.di.NavigationModule

internal val appModules: List<Module>
    get() = coreModules + featureModules

private val coreModules: List<Module>
    get() = listOf(
        NavigationModule().module,
    )

private val featureModules: List<Module>
    get() = listOf(
        HabitsFeatureModule().module
    )