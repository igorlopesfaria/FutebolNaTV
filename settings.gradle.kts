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
        maven ("https://jitpack.io") // <- here we go
    }
}
rootProject.name = "FutebolNaTV"

include(
    ":app",
    ":commons",
    ":data",
    ":domain",
    ":model",
    ":presentation"
)

