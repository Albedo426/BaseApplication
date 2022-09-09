package com.fyilmaz.template.ui.main.home.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fyilmaz.template.core.data.Result
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import com.fyilmaz.template.core.data.usecase.movie.UseCaseRandomUser
import com.fyilmaz.template.core.extensions.Event
import com.fyilmaz.template.core.platform.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val useCaseRandomUser: UseCaseRandomUser) : BaseViewModel() {

    private val _event = MutableLiveData<Event<HomeViewEvent>>()
    val event: LiveData<Event<HomeViewEvent>> = _event

    private val _userList = MutableLiveData<RandomUsers>()
    val userList: LiveData<RandomUsers> = _userList

    init {
        setLoading(true)
        Log.e("TAG", "setLoading(true)")
        viewModelScope.launch {
            // login işlemi gelecek
            // nullsafe için sistem eklenecek
            useCaseRandomUser.fetchData().collect {
                when (it) {
                    is Result.Error -> it.exception?.let { it1 -> handleException(it1) }
                    is Result.Success -> {
                        it.data.let { data ->
                            _userList.value = data
                            Log.e("TAG", "_userList.value = data")
                            setLoading(false)
                        }
                    }
                }
            }
        }
    }
}
