pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "FutebolNaTV"

include(
    ":app",
    ":commons",
    ":data",
    ":designsystem",
    ":domain",
    ":model",
    ":presentation"
)

