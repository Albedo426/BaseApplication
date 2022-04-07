plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    kotlin(Plugin.kapt)
    id(Plugin.daggerHiltPlugin)
    kotlin(Plugin.androidExtensions)
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
    api(Dependencies.Network.gson)
    api(Dependencies.Network.gsonAdapter)
    api(Dependencies.Network.retrofit)
    api(Dependencies.Network.rxJavaAdapter)
    api(Dependencies.Network.okHttp)
    api(Dependencies.Network.loggingInterceptor)
    api(Dependencies.Network.conscrypt)

    // DI
    implementation(Dependencies.DI.hilt)
    kapt(Dependencies.DI.hiltCompiler)

    // ReactiveFunc
    api(Dependencies.ReactiveFunc.rxJava)

    // Timber
    api(Dependencies.Tools.timber)

    //Testing
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.androidJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}
