import com.android.build.api.variant.KotlinMultiplatformAndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.configureAndroidLibrary
import org.ropotov.components.configureLibraryKotlinMultiplatform
import org.ropotov.components.logPlugin


class ModuleSetupGradlePlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        applyPlugins(Plugins.KOTLIN_MULTIPLATFORM, Plugins.KMP_LIBRARY)

        extensions
            .getByType<KotlinMultiplatformExtension>()
            .apply(::configureLibraryKotlinMultiplatform)
        extensions
            .getByType<KotlinMultiplatformAndroidComponentsExtension>()
            .apply(::configureAndroidLibrary)

        logPlugin("Applying ModuleSetupGradlePlugin to ${project.name}")
    }
}
