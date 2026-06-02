import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.ropotov.components.configureCoroutines
import org.ropotov.components.logPlugin

class CoroutinesConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        if (!plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) return@with
        extensions.getByType<KotlinMultiplatformExtension>().apply(::configureCoroutines)
        logPlugin("Applying CoroutinesConventionPlugin to ${project.name}")
    }
}