object Configs {
    const val applicationId = "com.fatihylmz"
    const val minSdkVersion = 26
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33
    const val buildToolsVersion = "1.0.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val versionCode = 1
    val versionName = calculateVersionName()
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    private fun calculateVersionName(): String = "$versionMajor.$versionMinor.$versionPatch"
}
