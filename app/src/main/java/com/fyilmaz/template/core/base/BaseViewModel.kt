package com.fyilmaz.template.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fyilmaz.template.core.extensions.Event
import com.google.gson.JsonSyntaxException
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class BaseViewModel() : ViewModel() {

    /**
     * [LiveData] that emits [ProgressState] to determine show/hide state of loading indicators(ie: HUD)
     */
    internal val progressStateObservable: MutableLiveData<ProgressState> by lazy {
        MutableLiveData()
    }

    internal var disposable = CompositeDisposable()

    private val _baseEvent = MutableLiveData<Event<BaseViewEvent>>()
    val baseEvent: LiveData<Event<BaseViewEvent>> = _baseEvent
    override fun onCleared() {
        disposeSubscriptions()
        super.onCleared()
    }
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun setLoading(loading: Boolean) = _loading.postValue(loading)

    /**
     * Disposes un-disposed subscriptions, should be called at onStop/onDestroy lifecycle state
     */

    internal fun disposeSubscriptions() {
        if (!disposable.isDisposed) disposable.dispose()
    }

    internal fun clearSubscriptions() {
        disposable.clear()
    }

    internal fun emitProgressShow() {
        progressStateObservable.postValue(ProgressState.Show)
    }

    internal fun emitProgressHide() {
        progressStateObservable.postValue(ProgressState.Hide)
    }

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }

    open fun handleException(e: Exception) {
        when (e) {
            is HttpException -> {
                when (e.code()) {
                    else -> try {
                        showCustomError(
                            "HttpException Error"
                        )
                    } catch (exception: Exception) {
                        showCommonNetworkError()
                    }
                }
            }

            is JsonSyntaxException -> showCommonNetworkError()

            is UnknownHostException -> showCommonNetworkError()
        }
    }

    private fun showCommonNetworkError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCommonNetworkError))

    private fun showConnectivityError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowConnectivityError))

    private fun showCustomError(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomError(message)))

    /**
     * Used with [progressStateObservable] for emitting state to show/hide loading indicators.(ie: HUD)
     */
    sealed class ProgressState {
        object Show : ProgressState()
        object Hide : ProgressState()
    }
}
