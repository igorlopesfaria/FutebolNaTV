plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdkVersion

    defaultConfig {
        applicationId = Apps.applicationId
        minSdk = Apps.minSdkVersion
        targetSdk = Apps.targetSdkVersion
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        manifestPlaceholders["scheme_app"] = Apps.scheme
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
            isDebuggable = true
            isMinifyEnabled = false
            multiDexEnabled = true
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            multiDexEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    buildFeatures {
        compose = true
    }

    lint {
        checkReleaseBuilds = false
        checkDependencies = true
        checkAllWarnings = true
        warningsAsErrors = true
        abortOnError = false
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    implementation(project(Module.commons))
    implementation(project(Module.designsystem))
    implementation(project(Module.data))
    implementation(project(Module.domain))
    implementation(project(Module.presentation))
    implementation(project(Module.model))

    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())
    kapt(Libs.Hilt.getHiltCompilerVersion())

    debugImplementation(Libs.Compose.getComposeToolingVersion())
    debugImplementation(Libs.Compose.getComposeTestManifestVersion())

    testImplementation(Libs.Test.getJunitVersion())
}