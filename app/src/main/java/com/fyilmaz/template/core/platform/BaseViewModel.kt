package com.fyilmaz.template.core.platform

import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fyilmaz.template.core.data.dto.error.ErrorResponse
import com.fyilmaz.template.core.extensions.Event
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

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
    open fun handleException(e: Exception) {
        setLoading(false)
        when (e) {
            is HttpException -> {
                when (e.code()) {
                    403 -> _baseEvent.postValue(Event(BaseViewEvent.ShowUserNotFoundError))
                    else -> {
                        if (e.code() in 499..599) {
                            _baseEvent.postValue(Event(BaseViewEvent.ShowInternalServerError))
                        } else {
                            try {
                                Gson().fromJson(
                                    e.response()?.errorBody()?.string(),
                                    ErrorResponse::class.java
                                )?.message?.let {
                                    showCustomError(
                                        it
                                    )
                                }
                            } catch (exception: Exception) {
                                showCommonNetworkError()
                            }
                        }
                    }
                }
            }

            is JsonSyntaxException -> showCommonNetworkError()

            is UnknownHostException -> showCommonNetworkError()
            is ConnectException -> showConnectivityError()
        }
    }

    /**
     * Disposes un-disposed subscriptions, should be called at onStop/onDestroy lifecycle state
     */

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

    fun encodeBase64(string: String): String {
        return Base64.encodeToString(
            string.toByteArray(),
            Base64.NO_WRAP
        )
    }


    private fun forceLogout() =
        _baseEvent.postValue(Event(BaseViewEvent.ForceLogout))
    fun showConnectivityError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowConnectivityError))

    fun showCustomError(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomError(message)))

    fun showCustomSuccess(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomSucess(message)))

    private fun showCommonNetworkError() =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCommonNetworkError))

    /**
     * Used with [progressStateObservable] for emitting state to show/hide loading indicators.(ie: HUD)
     */
    sealed class ProgressState {
        object Show : ProgressState()
        object Hide : ProgressState()
    }
}