import com.google.devtools.ksp.gradle.KspAATask
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.ropotov.components.Plugins
import org.ropotov.components.applyPlugins
import org.ropotov.components.configureKoin
import org.ropotov.components.libs
import org.ropotov.components.logPlugin

class KoinConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        if (!plugins.hasPlugin("com.google.devtools.ksp")) {
            applyPlugins(Plugins.KSP)
        }
        afterEvaluate {
            plugins.withId("com.google.devtools.ksp") {
                val koinCompiler = libs.findLibrary("koin-ksp-compiler").get()
                listOf(
                    "kspCommonMainMetadata",
                    "kspAndroid",
                    "kspIosArm64",
                    "kspIosSimulatorArm64"
                ).forEach { configName ->
                    if (configurations.findByName(configName) != null) {
                        dependencies.add(configName, koinCompiler.get())
                    } else {
                        logger.warn("Configuration '$configName' not found in project ${project.name}")
                    }
                }
                configureKoin(extensions.getByType(KotlinMultiplatformExtension::class.java))
                extensions.configure<KspExtension> {
                    arg("KOIN_CONFIG_CHECK", "false")
                    arg("KOIN_LOG_TIMES", "true")
                }
                tasks.withType(KspAATask::class.java).configureEach {
                    if (name != "kspCommonMainKotlinMetadata") {
                        dependsOn("kspCommonMainKotlinMetadata")
                    }
                }

                tasks.withType(KotlinCompilationTask::class.java).configureEach {
                    if (name != "kspCommonMainKotlinMetadata") {
                        dependsOn("kspCommonMainKotlinMetadata")
                    }
                }
            }
        }
        logPlugin("Applying KoinConventionPlugin to ${project.name}")
    }
}
