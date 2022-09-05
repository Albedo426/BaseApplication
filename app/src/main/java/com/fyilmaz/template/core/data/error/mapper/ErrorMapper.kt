package com.fyilmaz.template.core.data.error.mapper

import android.content.Context
import com.fyilmaz.template.core.data.error.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) :
    ErrorMapperSource {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, "R.string.no_internet"),
            Pair(NETWORK_ERROR, "R.string.network_error"),
            Pair(PASS_WORD_ERROR, "R.string.invalid_password"),
            Pair(USER_NAME_ERROR, "R.string.invalid_username"),
            Pair(CHECK_YOUR_FIELDS, "R.string.invalid_username_and_password"),
            Pair(SEARCH_ERROR, "R.string.search_error")
        ).withDefault { "R.string.network_error" }
}
