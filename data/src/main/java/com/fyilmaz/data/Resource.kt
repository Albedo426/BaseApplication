package com.fyilmaz.data
sealed class Resource<T>(val data: T? = null, val message: String? = null, val error: Exception? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null, error: Exception) : Resource<T>(data, message, error)
}
