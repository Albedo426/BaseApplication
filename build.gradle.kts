// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Classpaths.gradleClasspath)
        classpath(Classpaths.kotlinGradleClasspath)
        classpath(Classpaths.gradleVersionPlugin)
        classpath(Classpaths.hiltGradleClasspath)
    }
}

tasks.register("clean").configure {
    delete("build")
}
