package org.ropotov.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.configureRoom
import org.ropotov.components.libs
import org.ropotov.components.logPlugin

class RoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        if (!plugins.hasPlugin("com.google.devtools.ksp")) {
            applyPlugins(Plugins.KSP)
        }

        if (!plugins.hasPlugin("org.jetbrains.kotlin.plugin.serialization")) {
            applyPlugins(Plugins.KOTLIN_SERIALIZATION)
        }

        applyPlugins(Plugins.ROOM)

        afterEvaluate {
            plugins.withId("com.google.devtools.ksp") {
                val koinCompiler = libs.findLibrary("room-compiler").get()
                listOf(
                    "kspCommonMainMetadata",
                    "kspAndroid",
                    "kspIosX64",
                    "kspIosArm64",
                    "kspIosSimulatorArm64"
                ).forEach { configName ->
                    if (configurations.findByName(configName) != null) {
                        dependencies.add(configName, koinCompiler.get())
                    } else {
                        logger.warn("Configuration '$configName' not found in project ${project.name}")
                    }
                }
                configureRoom(extensions.getByType<KotlinMultiplatformExtension>())
            }
        }

        logPlugin("Applying RoomConventionPlugin to ${project.name}")
    }
}