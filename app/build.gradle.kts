plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.google.firebase.crashlytics")
}
android {
    compileSdk = Configs.compileSdkVersion
    buildToolsVersion = Configs.buildToolsVersion
    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = 28
        targetSdk = Configs.targetSdkVersion
        // multiDexEnabled = true
        versionCode = Configs.versionCode
        versionName = Configs.versionName
        testInstrumentationRunner = Configs.testInstrumentationRunner
    }

    buildTypes {
        getByName(Flavors.BuildTypes.DEBUG) {
            isDebuggable = true
        }
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

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    // Kotlin
    implementation(Dependencies.Kotlin.kotlinStdLib)
    implementation(Dependencies.Kotlin.kotlinCoroutinesCore)
    implementation(Dependencies.Kotlin.kotlinCoroutinesAndroid)

    // Android
    implementation(Dependencies.Android.androidCore)
    implementation(Dependencies.Android.androidCoreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.legacySupport)
    implementation(Dependencies.Android.multidex)
    implementation(Dependencies.Android.materialDesign)
    implementation(Dependencies.Android.fragment)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.recyclerView)
    implementation(Dependencies.Android.cardView)
    // Coroutines
    implementation(Dependencies.Coroutines.coroutinesTest)
    implementation(Dependencies.Coroutines.kotlinCoroutinesAdapter)

    // Navigation
    implementation(Dependencies.Navigation.runTimeNavigation)
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationDynamic)
    // LifeCycle
    implementation(Dependencies.LifeCycle.runTimeLiveCycle)
    implementation(Dependencies.LifeCycle.lifeCycleCompiler)
    implementation(Dependencies.LifeCycle.liveData)
    implementation(Dependencies.LifeCycle.viewModel)
    // Daager-Hilt
    implementation(Dependencies.DI.hilt)
    kapt(Dependencies.DI.hiltCompiler)
    // Network
    implementation(Dependencies.Network.gson)
    implementation(Dependencies.Network.gsonAdapter)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.rxJavaAdapter)
    implementation(Dependencies.Network.okHttp)
    implementation(Dependencies.Network.loggingInterceptor)

    // Firebase
    implementation(Dependencies.Firebase.firebaseBom)
    implementation(Dependencies.Firebase.firebaseCrashlytics)
    implementation(Dependencies.Firebase.firebaseAnalitics)
    implementation(Dependencies.Firebase.firebaseConfig)

    // Glide
    implementation(Dependencies.Glide.glide)
    annotationProcessor(Dependencies.Glide.glideCompiler)
    implementation(Dependencies.Tools.timber)

    // Testing
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.truthExt)
    testImplementation(Dependencies.Test.mockK)
    testImplementation(Dependencies.Test.coreTesting)
    testImplementation(Dependencies.Test.androidJunit)
    testImplementation(Dependencies.Test.espressoCore)
    testImplementation(Dependencies.DI.hiltAndroidTesting)

    // Google
    implementation(Dependencies.Google.googleLocation)

    // Dialog
    implementation(Dependencies.Dialogs.dialogCore)
    implementation(Dependencies.Dialogs.dateTime)

    // Room
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)

    // Paging
    implementation("androidx.paging:paging-common-ktx:3.1.1")
}
