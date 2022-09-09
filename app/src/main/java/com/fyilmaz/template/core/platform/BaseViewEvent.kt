package com.fyilmaz.template.core.platform

sealed class BaseViewEvent {
    data class ShowCustomError(val message: String) : BaseViewEvent()
}
