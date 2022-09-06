package com.fyilmaz.template.core.platform

sealed class BaseViewEvent {
    object ForceLogout : BaseViewEvent()

    object ShowCommonNetworkError : BaseViewEvent()

    object ShowConnectivityError : BaseViewEvent()

    object ShowUserNotFoundError : BaseViewEvent()

    object ShowInternalServerError : BaseViewEvent()

    data class ShowWarningError(val message: String) : BaseViewEvent()

    data class ShowCustomError(val message: String) : BaseViewEvent()

    data class ShowCustomSucess(val message: String) : BaseViewEvent()
}
