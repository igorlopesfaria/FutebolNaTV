plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

  // Moshi
  implementation(Libs.Moshi.getMoshiVersion())
  // Retrofit
  implementation(Libs.Retrofit.getRetrofitCoreVersion())
  implementation(Libs.Retrofit.getRetrofitMoshiConverterVersion())

}