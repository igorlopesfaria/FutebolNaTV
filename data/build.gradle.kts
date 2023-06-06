plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    compileSdk = Apps.compileSdkVersion
    namespace = "br.com.futebolnatv.data"

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
}

dependencies {
    implementation(project(Module.commons))
    implementation(project(Module.model))

    //Dagger Hilt
    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    kapt(Libs.DaggerHilt.getDaggerHiltCompilerVersion())

    //Hilt
    kapt(Libs.Hilt.getHiltCompilerVersion())

    // Okhttp3
    implementation(platform(Libs.OkHttp3.getBoomVersion()))
    implementation(Libs.OkHttp3.getCoreVersion())
    implementation(Libs.OkHttp3.getInterceptorVersion())

    // Retrofit
    implementation(Libs.Retrofit.getRetrofitCoreVersion())
    implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())

    // Coroutines
    api(Libs.Coroutines.getCoreVersion())
    api(Libs.Coroutines.getAndroidVersion())

    // Moshi
    implementation(Libs.Moshi.getMoshiVersion())

    // Test
    testImplementation(Libs.Test.getJunitVersion())
    testImplementation(Libs.Test.getMockkVersion())
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_VERSION}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:${Versions.COROUTINES_VERSION}")

}