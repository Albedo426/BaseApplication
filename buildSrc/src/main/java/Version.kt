object Version {

    object Gradle {
        const val gradleVersionPluginVersion = "0.27.0"
        const val gradleVersion = "4.2.1"
        const val hiltVersion = "2.40.5"
        const val navigationVersion = "2.4.2"
    }

    object Kotlin {
        const val kotlinVersion = "1.6.10"
        const val kotlinStdLib = kotlinVersion
        const val kotlinCoroutinesCore = "1.3.9"
    }

    object Android {
        const val appCompat = "1.4.0"
        const val extJunit = "1.1.3"
        const val espressoCore = "3.4.0"
        const val androidCore = "1.7.0"
        const val legacySupport = "1.0.0"
        const val multiDex = "2.0.1"
        const val materialDesign = "1.4.0"
        const val fragmentVersion = "1.3.6"
        const val constraintLayout = "2.1.0"
        const val recyclerView = "1.2.0"
        const val recyclerViewSelection = "1.1.0"
        const val cardView = "1.0.0"
        const val palette = "1.0.0"
        const val workManager = "2.5.0"
    }

    object Navigation {
        const val navigationVersion = "2.4.2"
        const val runTimeNavigation = navigationVersion
        const val navigationFragment = navigationVersion
        const val navigationUI = navigationVersion
    }

    object LifeCycle {
        private const val lifecycleVersion = "2.4.0-alpha02"
        const val runTimeLifeCycle = lifecycleVersion
        const val lifeCycleCompiler = lifecycleVersion
        const val liveData = lifecycleVersion
        const val viewModel = lifecycleVersion
        const val viewModelState = lifecycleVersion
    }

    object DI {
        const val hilt = "2.40.5"
        const val hiltComp = "2.40"
        const val hiltWork = "1.0.0"
        const val hiltNavigation = "1.0.0"
        const val hiltViewModel = "1.0.0-alpha03"
        const val hiltCompiler = "1.0.0"
    }

    object ReactiveFunc {
        const val rxJava = "3.0.13"
        const val rxKotlin = "3.0.1"
        const val rxAndroid = "3.0.0"
    }

    object Network {
        const val conscrypt = "2.5.1"
        const val gson = "2.8.7"
        const val retrofit = "2.9.0"
        const val moshi = retrofit
        const val moshiKotlin = "1.11.0"
        const val rxJava3Adapter = retrofit
        const val gsonConverter = retrofit
        const val okHttp = "4.9.1"
        const val loggingInterceptor = okHttp
    }
    object Tools {
        const val timber = "4.7.1"
        const val lottie = "3.7.0"
        const val coil = "1.4.0"
        const val storyView = "1.0.2-alpha"
        const val roundedImageView = "2.3.0"
        const val whynotimagecarousel = "2.0.6"
        const val materialSearchBar = "0.8.5"
    }

    object Dialogs {
        const val core = "3.0.0"
    }

    object Test {
        const val junit = "4.+"
        const val androidJunit = "1.1.2"
        const val espressoCore = "3.3.0"
        const val truthExtVersion = "1.3.0-alpha01"
        const val mockKVersion = "1.9.3"
        const val coreTestingVersion = "2.0.0"
        const val hiltTesting = "2.28-alpha"
        const val hiltTestCompiler = hiltTesting
    }
}