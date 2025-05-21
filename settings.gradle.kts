pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Google repository faqat bu yerda bo‘lishi kerak
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
        maven{
            url = uri("https://jitpack.io")
        }

    }
}


rootProject.name = "Doppigramm"
include(":app")
 