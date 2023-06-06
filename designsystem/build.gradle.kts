plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    compileSdk = Apps.compileSdkVersion
    namespace = "br.com.futebolnatv.designsystem"

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

    implementation(platform("androidx.compose:compose-bom:2023.01.00"))

    api(Libs.Compose.getComposeUIVersion())
    api(Libs.Compose.getComposeMaterial3Version())
    api(Libs.Compose.getComposeToolingPreviewVersion())
    debugImplementation(Libs.Compose.getComposeToolingVersion())
    androidTestImplementation(Libs.Compose.getComposeTestJUnitVersion())
}