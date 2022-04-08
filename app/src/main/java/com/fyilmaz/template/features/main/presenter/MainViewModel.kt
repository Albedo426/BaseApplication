package com.fyilmaz.template.features.main.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fyilmaz.data.Resource
import com.fyilmaz.data.remote.response.anime.AnimeList
import com.fyilmaz.template.core.base.BaseViewModel
import com.fyilmaz.template.core.extensions.Event
import com.fyilmaz.template.features.main.domain.MainUseCase
import com.fyilmaz.template.features.main.domain.MainViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : BaseViewModel() {

    private val _popular = MutableLiveData<AnimeList?>()
    val popular: LiveData<AnimeList?> = _popular

    private val _event = MutableLiveData<Event<MainViewEvent>>()
    val event: LiveData<Event<MainViewEvent>> = _event

    fun fetchPopulars() {
        setLoading(true)
        viewModelScope.launch {
            val response = useCase.fetchPopular()
            when (response) {
                is Resource.Success -> _popular.postValue(response.data)
                is Resource.Error -> handleException(response.error!!)
            }.also { setLoading(false) }
        }
    }

    fun navigateToDetail(pop: AnimeList.Anime) {
        _event.postValue(Event(MainViewEvent.NavigateToDetails(pop)))
    }
}
