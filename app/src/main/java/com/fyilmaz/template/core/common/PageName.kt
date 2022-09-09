package com.fyilmaz.template.core.common

object PageName {
    val main = "baseApp:/"

    object Login {
        private val mainPath = "$main/auth"
        private val preLogin = "$main/preLogin"
        val splash = "$preLogin/splash"
        val login = "$mainPath/login"
    }

    object Main {
        private val mainPath = "$main/main"
        val home = "$mainPath/home"
    }

}
