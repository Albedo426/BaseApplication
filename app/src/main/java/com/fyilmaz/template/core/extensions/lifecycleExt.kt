package com.fyilmaz.template.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


fun <T> LifecycleOwner.observeLiveData(liveData: LiveData<T>, observer: (T) -> Unit) {
    liveData.observe(
        this,
        Observer {
            it?.let { t -> observer(t) }
        }
    )
}

fun <T> LifecycleOwner.observeMutableLiveData(liveData: MutableLiveData<T>, observer: (T) -> Unit) {
    liveData.observe(
        this,
        Observer {
            it?.let { t -> observer(t) }
        }
    )
}

fun <T> LifecycleOwner.observeEvent(liveData: LiveData<Event<T>>, observer: (T) -> Unit) {
    liveData.observe(
        this,
        Observer {
            it?.getContentIfNotHandled()?.let { t -> observer(t) }
        }
    )
}
