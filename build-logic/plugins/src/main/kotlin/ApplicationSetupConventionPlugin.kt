import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.configureAndroidApplication
import org.ropotov.components.logPlugin

class ApplicationSetupConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        applyPlugins(Plugins.ANDROID_APPLICATION, Plugins.COMPOSE_COMPILER)
        extensions.configure<ApplicationExtension>(::configureAndroidApplication)
        logPlugin("Applying ApplicationSetupConventionPlugin to ${project.name}")
    }
}