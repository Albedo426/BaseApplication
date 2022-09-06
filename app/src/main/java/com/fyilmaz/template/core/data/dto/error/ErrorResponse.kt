package com.fyilmaz.template.core.data.dto.error

data class ErrorResponse(
    val error: Int,
    val message: String? = ""
)

const val NO_INTERNET_CONNECTION = -1
const val NETWORK_ERROR = -2
const val DEFAULT_ERROR = -3
const val PASS_WORD_ERROR = -101
const val USER_NAME_ERROR = -102
const val CHECK_YOUR_FIELDS = -103
const val SEARCH_ERROR = -104
