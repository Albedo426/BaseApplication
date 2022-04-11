import Dependencies.Project.data

plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
    kotlin(Plugin.kapt)
    kotlin(Plugin.androidExtensions)
    id(Plugin.daggerHiltPlugin)
}
android {
    compileSdkVersion(Config.compileSdkVersion)
    buildToolsVersion = Config.buildToolsVersion
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        multiDexEnabled = true
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(Flavors.BuildTypes.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(data())

    // Kotlin
    implementation(Dependencies.Kotlin.kotlinStdLib)
    implementation(Dependencies.Kotlin.kotlinCoroutinesCore)
    implementation(Dependencies.Kotlin.kotlinCoroutinesAndroid)
    // Timber
    implementation(Dependencies.Tools.timber)
    implementation(Dependencies.Tools.coil)
    // implementation(Dependencies.Tools.storyView)

    // Android
    implementation(Dependencies.Android.androidCore)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.materialDesign)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.androidEspressoCore)
    implementation(Dependencies.Android.androidExtJunit)
    implementation(Dependencies.Android.androidJunit)
    implementation(Dependencies.Android.legacySupport)
    implementation(Dependencies.Android.multidex)
    implementation(Dependencies.Android.fragment)
    implementation(Dependencies.Android.recyclerView)
    implementation(Dependencies.Android.recyclerViewSelection)
    implementation(Dependencies.Android.cardView)
    implementation(Dependencies.Android.palette)
    implementation(Dependencies.Android.workManger)

    // Coroutines
    implementation(Dependencies.Coroutines.kotlinCoroutinesAdapter)

    // Navigation
    implementation(Dependencies.Navigation.runTimeNavigation)
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)

    // Network
    implementation(Dependencies.Network.moshi)
    implementation(Dependencies.Network.moshiKotlin)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.rxJavaAdapter)
    implementation(Dependencies.Network.okHttp)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Network.conscrypt)
    implementation(Dependencies.Network.gson)
    implementation(Dependencies.Network.gsonAdapter)

    // TOOLS
    implementation(Dependencies.Tools.roundedImageView)
    implementation(Dependencies.Tools.whynotimagecarousel)

    // DI
    implementation(Dependencies.DI.hilt)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(Dependencies.DI.hiltCompiler)

    // Testing
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.truthExt)
    testImplementation(Dependencies.Test.mockK)
    testImplementation(Dependencies.Test.coreTesting)
    androidTestImplementation(Dependencies.Test.androidJunit)
}
