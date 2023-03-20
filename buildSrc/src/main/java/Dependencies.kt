object Apps {
    const val compileSdkVersion = 33
    const val minSdkVersion = 24
    const val targetSdkVersion = 32
    const val versionName = "1.0.0"
    const val versionCode = 1

    const val groupId = "br.com.futebolnatv"
    const val applicationId = groupId
    const val scheme = "futebolnatv"

}

object Module {
    const val commons = ":commons"
    const val data = ":data"
    const val designsystem = ":designsystem"
    const val domain = ":domain"
    const val model = ":model"
    const val presentation = ":presentation"
}

object Versions {

    const val KOTLIN_VERSION = "1.6.21"
    const val ANDROIDX_CORE_VERSION = "1.9.0"
    const val GRADLE_PLUGIN_VERSION = "7.2.2"

    const val SPOTLESS_VERSION = "6.4.1"
    const val LIFECYCLE_VERSION = "2.5.1"
    const val SUPPORT_VERSION = "1.6.1"
    const val CONSTRAINT_VERSION = "2.1.4"
    const val CARDVIEW_VERSION = "1.0.0"
    const val MATERIAL_VERSION = "1.8.0"
    const val DYNAMICANIMATION_VERSION = "1.0.0"

    const val MOSHI_VERSION = "1.14.0"
    const val RETROFIT_VERSION = "2.9.0"
    const val OKHTTP_VERSION = "4.10.0"

    const val COROUTINES_VERSION = "1.6.4"

    const val ACTIVITY_VERSION = "1.6.1"

    const val HILT_VERSION = "1.0.0"
    const val DAGGER_HILT_VERSION = "2.42"

    const val MOCKK_VERSION = "1.10.5"
    const val TEST_VIEWMODEL_VERSION = "1.10.5"
    const val TEST_RUNNER_VERSION = "1.4.0"
    const val TEST_JUNIT_VERSION = "4.13.2"
    const val ROBOLECTRIC_VERSION = "4.5.1"
    const val ESPRESSO_VERSION = "4.5.1"

    const val GOOGLE_SERVICE_VERSION = "4.2.0"
}

object Libs {

    object Gradle {
        fun getToolsGradleVersion() = "com.android.tools.build:gradle:${Versions.GRADLE_PLUGIN_VERSION}"
    }

    object Kotlin {
        fun getKotlinGradlePluginVersion() = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
        fun getKotlinStdlibVersion() = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_VERSION}"
        fun getKotlinReflectVersion() = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN_VERSION}"
        fun coreKtxVersion() = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE_VERSION}"
    }

    object Support {
        fun getSupportV7Version() = "androidx.appcompat:appcompat:${Versions.SUPPORT_VERSION}"
        fun getSupportConstraintLayoutVersion() = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_VERSION}"
        fun getSupportDesignVersion() = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
        fun getSupportCardViewVersion() = "androidx.cardview:cardview:${Versions.CARDVIEW_VERSION}"
        fun getSupportAnimationVersion() = "androidx.dynamicanimation:dynamicanimation:${Versions.DYNAMICANIMATION_VERSION}"
    }

    object Activity {
        fun getActivityComposeVersion() = "androidx.activity:activity-compose:${Versions.ACTIVITY_VERSION}"
    }

    object Compose {
        fun getComposeUIVersion() = "androidx.compose.ui:ui"
        fun getComposeMaterialVersion() = "androidx.compose.material:material"
        fun getComposeToolingPreviewVersion() = "androidx.compose.ui:ui-tooling-preview"

        fun getComposeLiveDataVersion() = "androidx.compose.runtime:runtime-livedata:1.3.3"
        fun getComposeToolingVersion() = "androidx.compose.ui:ui-tooling"
        fun getComposeTestJUnitVersion() = "androidx.compose.ui:ui-test-junit4"
        fun getComposeTestManifestVersion() = "androidx.compose.ui:ui-tooling"
    }

    object LifeCycleVersion {
        fun getLifeCycleViewModelVersion() = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
        fun getLifeCycleComposeViewModelVersion() = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE_VERSION}"
    }

    object Retrofit {
        fun getRetrofitCoreVersion() = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
        fun getRetrofitMoshiConverterVersion() = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT_VERSION}"
    }

    object Moshi {
        fun getMoshiVersion() = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI_VERSION}"
    }

    object OkHttp3 {
        fun getBoomVersion() = "com.squareup.okhttp3:okhttp-bom:${Versions.OKHTTP_VERSION}"
        fun getCoreVersion() = "com.squareup.okhttp3:okhttp"
        fun getInterceptorVersion() = "com.squareup.okhttp3:logging-interceptor"

    }

    object Coroutines {
        fun getCoreVersion() = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
        fun getAndroidVersion() = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    }

    object Spotless {
        fun getSpotlessVersion(): String = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.SPOTLESS_VERSION}"
    }

    object Hilt {
        fun getHiltCompilerVersion(): String = "androidx.hilt:hilt-compiler:${Versions.HILT_VERSION}"
    }

    object DaggerHilt {
        fun getDaggerHiltPluginVersion() = "com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT_VERSION}"
        fun getDaggerHiltAndroidVersion() = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT_VERSION}"
        fun getDaggerHiltCompilerVersion() = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT_VERSION}"
        fun getDaggerHiltNavigationComposeVersion(): String = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_VERSION}"
    }

    object Test {
        fun getCoreVersion() = "androidx.test:core:${Versions.TEST_RUNNER_VERSION}"
        fun getJunitVersion() = "junit:junit:${Versions.TEST_JUNIT_VERSION}"
        fun getViewModelTestVersion() = "androidx.arch.core:core-testing:${Versions.TEST_VIEWMODEL_VERSION}"
        fun getMockkVersion() = "io.mockk:mockk:${Versions.MOCKK_VERSION}"
        fun getRobolectricVersion() = "org.robolectric:robolectric:${Versions.ROBOLECTRIC_VERSION}"
        fun getEspressoVersion() = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    }
}
