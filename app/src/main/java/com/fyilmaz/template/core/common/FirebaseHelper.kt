package com.fyilmaz.template.core.common

import android.os.Bundle

object FirebaseHelper {
    fun generateFirebaseEventParams(
        eventList: ArrayList<Pair<String, String>>
    ): Bundle {
        val bundle = Bundle()
        eventList.forEach { bundle.putString(it.first, it.second) }
        return bundle
    }
}
