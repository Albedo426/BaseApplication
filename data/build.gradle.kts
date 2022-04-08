plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    kotlin(Plugin.kapt)
    kotlin(Plugin.androidExtensions)
    id(Plugin.daggerHiltPlugin)

}
android {
    compileSdkVersion(Config.compileSdkVersion)
    buildToolsVersion = Config.buildToolsVersion
    defaultConfig {
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)

        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName(Flavors.BuildTypes.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    // Kotlin
    implementation(Dependencies.Kotlin.kotlinStdLib)

    // Android
    implementation(Dependencies.Android.androidCore)

    // Network
    implementation(Dependencies.Network.gson)
    implementation(Dependencies.Network.gsonAdapter)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.rxJavaAdapter)
    implementation(Dependencies.Network.okHttp)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Network.conscrypt)
    implementation(Dependencies.Network.conscrypt)
    implementation(Dependencies.Network.moshi)
    // DI
    implementation(Dependencies.DI.hilt)
    kapt(Dependencies.DI.hiltCompiler)

    // Navigation
    implementation(Dependencies.Navigation.runTimeNavigation)
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)


    // ReactiveFunc
    implementation(Dependencies.ReactiveFunc.rxJava)

    // Timber
    implementation(Dependencies.Tools.timber)

    // Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.androidJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}
