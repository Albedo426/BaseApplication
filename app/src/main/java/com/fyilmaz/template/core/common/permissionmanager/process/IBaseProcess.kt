package com.fyilmaz.template.core.common.permissionmanager.process

interface IBaseProcess<T> {
    fun successPermission(successEvent: T? = null)
    fun unsuccessfulPermission(errorString: String? = null)
    fun loopPermission(loopEvent: T? = null)
}
