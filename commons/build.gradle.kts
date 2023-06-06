plugins {
  id("com.android.library")
  id("kotlin-android")
  id("kotlin-parcelize")
  id("kotlin-kapt")
}

android {
  compileSdk = Apps.compileSdkVersion
  namespace = "br.com.futebolnatv.commons"

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

  // Moshi
  implementation(Libs.Moshi.getMoshiVersion())
  // Retrofit
  implementation(Libs.Retrofit.getRetrofitCoreVersion())
  implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())

}