buildscript {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Classpaths.gradleClasspath)
        classpath(Classpaths.kotlinGradleClasspath)
        classpath(Classpaths.kotlinSerialization)
        classpath(Classpaths.safeVarargs)
        classpath(Classpaths.hiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
tasks.register("clean").configure {
    delete("build")
}
