package com.fyilmaz.data
sealed class Resource<T>(val data: T? = null, val message: String? = null, val error: Throwable? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null, error: Throwable) : Resource<T>(data, message, error)
}
