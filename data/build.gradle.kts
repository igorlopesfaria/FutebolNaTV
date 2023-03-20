plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
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
}