plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdkVersion
    namespace = "br.com.futebolnatv.presentation"

    defaultConfig {
        minSdk = Apps.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    buildFeatures {
        compose = true
    }


}

dependencies {
    implementation(project(Module.commons))
    implementation(project(Module.domain))
    implementation(project(Module.model))

    //Compose
    implementation(platform(Libs.Compose.getComposeBOM()))
    implementation(Libs.Compose.getComposeMaterial3Version())
    implementation(Libs.Activity.getActivityComposeVersion())
    implementation(Libs.LifeCycleVersion.getLifeCycleComposeViewModelVersion())
    implementation(Libs.Compose.getComposeLiveDataVersion())
    debugImplementation(Libs.Compose.getComposeToolingVersion())
    androidTestImplementation(Libs.Compose.getComposeTestJUnitVersion())

    //Lottie
    implementation (Libs.Lottie.getLottieComposeVersion())
    implementation (Libs.Lottie.getLottieVersion())

    //Dagger Hilt
    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())

    //JUnit
    testImplementation(Libs.Test.getJunitVersion())

    implementation(Libs.Helium.getHeliumCoreVersion())
    implementation(Libs.Helium.getHeliumChipVersion())
    implementation(Libs.Helium.getHeliumStatusViewVersion())
}