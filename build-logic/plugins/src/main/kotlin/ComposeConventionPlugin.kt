import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.configureComposeMultiplatform
import org.ropotov.components.logPlugin

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        applyPlugins(Plugins.COMPOSE_MULTIPLATFORM, Plugins.COMPOSE_COMPILER)
        extensions.getByType<KotlinMultiplatformExtension>().apply(::configureComposeMultiplatform)
        logPlugin("Applying ComposeConventionPlugin to ${project.name}")
    }
}