package com.fyilmaz.template.ui.main.home.domain


sealed class HomeViewEvent {
    object GoReturn : HomeViewEvent()
}