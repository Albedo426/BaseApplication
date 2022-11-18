package com.fyilmaz.template.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fyilmaz.template.core.common.MyTimer
import com.fyilmaz.template.core.common.TimerType
import com.fyilmaz.template.core.data.dto.error.ErrorResponse
import com.fyilmaz.template.core.extensions.Event
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

abstract class BaseViewModel : ViewModel() {

    private val progressStateObservable: MutableLiveData<ProgressState> by lazy {
        MutableLiveData()
    }

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _baseEvent = MutableLiveData<Event<BaseViewEvent>>()
    val baseEvent: LiveData<Event<BaseViewEvent>> = _baseEvent

    fun setLoading(loading: Boolean) = _loading.postValue(loading)

    var myTimer: MyTimer? = null

    fun runTimer(
        onFinish: () -> Unit,
        onTick: (millisUntilFinished: Long) -> Unit,
        millisInFuture: Long,
        countDownInterval: Long = 1,
        timerLifecycle: Boolean=true,
        typeTimer: TimerType = TimerType.OneTimeTimer,
        oneTask: Boolean = true
    ) {
        myTimer = MyTimer(millisInFuture, countDownInterval)
        myTimer?.startTimer(
            {
                onFinish()
            },
            {
                onTick(it)
            },
            typeTimer,
            timerLifecycle,
            oneTask
        )
    }
    override fun onCleared() {
        super.onCleared()
        myTimer?.timerClose()
    }

    open fun handleException(e: ErrorResponse) {
        setLoading(false)
        e.message?.let {
            showCustomError(
                it
            )
        }
    }
    internal fun emitProgressShow() {
        progressStateObservable.postValue(ProgressState.Show)
    }

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }

    fun showCustomError(message: String) =
        _baseEvent.postValue(Event(BaseViewEvent.ShowCustomError(message)))

    sealed class ProgressState {
        object Show : ProgressState()
        object Hide : ProgressState()
    }
}
