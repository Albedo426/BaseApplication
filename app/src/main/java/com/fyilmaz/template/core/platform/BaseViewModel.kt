package com.fyilmaz.template.core.platform

import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fyilmaz.template.core.data.dto.error.ErrorResponse
import com.fyilmaz.template.core.extensions.Event
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    internal val progressStateObservable: MutableLiveData<ProgressState> by lazy {
        MutableLiveData()
    }
    internal var disposable = CompositeDisposable()

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _baseEvent = MutableLiveData<Event<BaseViewEvent>>()
    val baseEvent: LiveData<Event<BaseViewEvent>> = _baseEvent

    fun setLoading(loading: Boolean) = _loading.postValue(loading)

    open fun handleException(e: ErrorResponse) {
        setLoading(false)
        e.message?.let {
            showCustomError(
                it
            )
        }
    }


    private fun disposeSubscriptions() {
        if (!disposable.isDisposed) disposable.dispose()
    }

    internal fun clearSubscriptions() {
        disposable.clear()
    }

    internal fun emitProgressShow() {
        progressStateObservable.postValue(ProgressState.Show)
    }

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }

    override fun onCleared() {
        disposeSubscriptions()
        super.onCleared()
    }

    fun showCustomError(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomError(message)))


    /**
     * Used with [progressStateObservable] for emitting state to show/hide loading indicators.(ie: HUD)
     */
    sealed class ProgressState {
        object Show : ProgressState()
        object Hide : ProgressState()
    }
}
