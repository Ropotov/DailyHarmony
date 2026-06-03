rootProject.name = "DailyHarmony"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google ()
        mavenCentral()
    }
}

include(":androidApp")
include(":shared")

include(":core:navigation")
include(":core:common")

include(":feature:habits")