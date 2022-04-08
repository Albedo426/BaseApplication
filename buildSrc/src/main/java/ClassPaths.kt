object Classpaths {
    const val gradleClasspath =
        "com.android.tools.build:gradle:${Version.Gradle.gradleVersion}"
    const val kotlinGradleClasspath =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin.kotlinVersion}"
    const val gradleVersionPlugin =
        "com.github.ben-manes:gradle-versions-plugin:${Version.Gradle.gradleVersionPluginVersion}"
    const val hiltGradleClasspath =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.Gradle.hiltVersion}"
    const val navigationClasspath =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Gradle.navigationVersion}"
}