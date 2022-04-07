package com.fyilmaz.template.core.base


sealed class BaseViewEvent {


    object ShowCommonNetworkError : BaseViewEvent()

    object ShowConnectivityError : BaseViewEvent()

    data class ShowCustomError(val message: String) : BaseViewEvent()
}