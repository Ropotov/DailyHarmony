import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.logPlugin

class KMPSetupConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        applyPlugins(
            Plugins.KOTLIN_MULTIPLATFORM,
            Plugins.COMPOSE_MULTIPLATFORM,
            Plugins.COMPOSE_COMPILER
        )
        extensions.configure<KotlinMultiplatformExtension> {
            iosArm64()
            iosSimulatorArm64()
        }

        logPlugin("Applying KMPSetupConventionPlugin to ${project.name}")
    }
}