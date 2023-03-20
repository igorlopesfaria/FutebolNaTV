plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdkVersion

    defaultConfig {
        minSdk = Apps.minSdkVersion
        targetSdk = Apps.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }

}

dependencies {
    implementation(project(Module.commons))
    implementation(project(Module.designsystem))
    implementation(project(Module.domain))
    implementation(project(Module.model))

    implementation(Libs.Activity.getActivityComposeVersion())
    implementation(Libs.LifeCycleVersion.getLifeCycleComposeViewModelVersion())

    implementation(Libs.Compose.getComposeLiveDataVersion())
    debugImplementation(Libs.Compose.getComposeToolingVersion())
    debugImplementation(Libs.Compose.getComposeTestManifestVersion())
    androidTestImplementation(Libs.Compose.getComposeTestJUnitVersion())

    //Dagger Hilt
    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())

    testImplementation(Libs.Test.getJunitVersion())
}