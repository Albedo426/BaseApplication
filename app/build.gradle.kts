import Dependencies.Project.data

plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
    kotlin(Plugin.kapt)
    // id(Plugin.daggerHiltPlugin)
    kotlin(Plugin.androidExtensions)
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

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(data())

    // Kotlin
   /* implementation(Dependencies.Kotlin.kotlinStdLib)
    implementation(Dependencies.Kotlin.kotlinCoroutinesCore)
    implementation(Dependencies.Kotlin.kotlinCoroutinesAndroid)*/

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

    // Testing
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.truthExt)
    testImplementation(Dependencies.Test.mockK)
    testImplementation(Dependencies.Test.coreTesting)
    androidTestImplementation(Dependencies.Test.androidJunit)
}
