import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    object Kotlin {
        const val kotlinStdLib =
            "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin.kotlinStdLib}"
        const val kotlinCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Kotlin.kotlinCoroutinesCore}"
        const val kotlinCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Kotlin.kotlinCoroutinesCore}"

        object Test {
            const val common =
                "org.jetbrains.kotlin:kotlin-test-common:${Version.Kotlin.kotlinVersion}"
            const val annotations =
                "org.jetbrains.kotlin:kotlin-test-annotations-common:${Version.Kotlin.kotlinVersion}"
            const val junit =
                "org.jetbrains.kotlin:kotlin-test-junit:${Version.Kotlin.kotlinVersion}"
        }
    }

    object Android {
        const val androidJunit =
            "junit:junit:"
        const val androidExtJunit =
            "androidx.core:core-ktx:${Version.Android.extJunit}"
        const val androidEspressoCore =
            "androidx.test.espresso:espresso-core:${Version.Android.espressoCore}"
        const val androidCore =
            "androidx.core:core-ktx:${Version.Android.androidCore}"
        const val appCompat =
            "androidx.appcompat:appcompat:${Version.Android.appCompat}"
        const val legacySupport =
            "androidx.legacy:legacy-support-v4:${Version.Android.legacySupport}"
        const val multidex =
            "androidx.multidex:multidex:${Version.Android.multiDex}"
        const val materialDesign =
            "com.google.android.material:material:${Version.Android.materialDesign}"
        const val fragment =
            "androidx.fragment:fragment-ktx:${Version.Android.fragmentVersion}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.Android.constraintLayout}"
        const val recyclerView =
            "androidx.recyclerview:recyclerview:${Version.Android.recyclerView}"
        const val recyclerViewSelection =
            "androidx.recyclerview:recyclerview:${Version.Android.recyclerViewSelection}"
        const val cardView =
            "androidx.cardview:cardview:${Version.Android.cardView}"
        const val palette =
            "androidx.palette:palette-ktx:${Version.Android.palette}"
        const val workManger =
            "androidx.work:work-runtime-ktx:${Version.Android.workManager}"
    }

    object Coroutines {

        // Coroutines
        const val coroutinesAandroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2"
        const val kotlinCoroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
    }

    object Navigation {
        const val runTimeNavigation =
            "androidx.navigation:navigation-runtime-ktx:${Version.Navigation.runTimeNavigation}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.Navigation.navigationFragment}"
        const val navigationUi =
            "androidx.navigation:navigation-ui-ktx:${Version.Navigation.navigationUI}"
    }

    object LifeCycle {
        const val runTimeLiveCycle =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LifeCycle.runTimeLifeCycle}"
        const val lifeCycleCompiler =
            "androidx.lifecycle:lifecycle-compiler:${Version.LifeCycle.viewModelState}"
        const val liveData =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LifeCycle.liveData}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LifeCycle.viewModel}"
        const val viewModelState =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.LifeCycle.viewModelState}"
    }

    object DI {
        const val hilt =
            "com.google.dagger:hilt-android:${Version.DI.hilt}"
        const val hiltWork =
            "androidx.hilt:hilt-work:${Version.DI.hiltWork}"
        const val hiltCompiler =
            "com.google.dagger:hilt-android-compiler:${Version.DI.hiltComp}"
        const val hiltNavigation =
            "androidx.hilt:hilt-navigation-fragment:${Version.DI.hiltNavigation}"
        const val hiltViewModel =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Version.DI.hiltViewModel}"
        const val hiltWorkManagerCompiler =
            "androidx.hilt:hilt-compiler:${Version.DI.hiltCompiler}"
    }

    object ReactiveFunc {
        const val rxJava =
            "io.reactivex.rxjava3:rxjava:${Version.ReactiveFunc.rxJava}"
        const val rxKotlin =
            "io.reactivex.rxjava3:rxkotlin:${Version.ReactiveFunc.rxKotlin}"
        const val rxAndroid =
            "io.reactivex.rxjava3:rxandroid:${Version.ReactiveFunc.rxAndroid}"
    }

    object Network {
        const val moshi =
            "com.squareup.retrofit2:converter-moshi:${Version.Network.moshi}"
        const val moshiKotlin =
            "com.squareup.moshi:moshi-kotlin:${Version.Network.moshiKotlin}"
        const val gson =
            "com.google.code.gson:gson:${Version.Network.gson}"
        const val gsonAdapter =
            "com.squareup.retrofit2:converter-gson:${Version.Network.gsonConverter}"
        const val retrofit =
            "com.squareup.retrofit2:retrofit:${Version.Network.retrofit}"
        const val rxJavaAdapter =
            "com.squareup.retrofit2:adapter-rxjava3:${Version.Network.rxJava3Adapter}"
        const val okHttp =
            "com.squareup.okhttp3:okhttp:${Version.Network.okHttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Version.Network.loggingInterceptor}"
        const val conscrypt =
            "org.conscrypt:conscrypt-android:${Version.Network.conscrypt}"
    }

    object Tools {

        const val roundedImageView =
            "com.makeramen:roundedimageview:${Version.Tools.roundedImageView}"
        const val whynotimagecarousel =
            "org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:${Version.Tools.whynotimagecarousel}"

        const val coil =
            "io.coil-kt:coil:${Version.Tools.coil}"
        const val timber =
            "com.jakewharton.timber:timber:${Version.Tools.timber}"
        const val lottie =
            "com.airbnb.android:lottie:${Version.Tools.lottie}"
    }

    object Dialogs {
        const val dialogCore = "com.afollestad.material-dialogs:core:${Version.Dialogs.core}"
    }
    object Project {
        fun DependencyHandler.app() = project(mapOf("path" to ":app"))
        fun DependencyHandler.data() = project(mapOf("path" to ":data"))
    }
    object Test {
        const val junit =
            "junit:junit:${Version.Test.junit}"
        const val androidJunit =
            "androidx.test.ext:junit:${Version.Test.androidJunit}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Version.Test.espressoCore}"
        const val truthExt =
            "androidx.test.ext:truth:${Version.Test.truthExtVersion}"
        const val mockK =
            "io.mockk:mockk:${Version.Test.mockKVersion}"
        const val coreTesting =
            "androidx.arch.core:core-testing:${Version.Test.coreTestingVersion}"
    }
}
