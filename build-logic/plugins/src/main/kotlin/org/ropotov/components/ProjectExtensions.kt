package org.ropotov.components

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.applyPlugins(vararg pluginAliases: Plugins) {
    pluginAliases.forEach { alias ->
        pluginManager.apply(libs.findPlugin(alias.id).get().get().pluginId)
    }
}