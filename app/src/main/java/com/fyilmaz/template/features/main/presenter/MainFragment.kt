package com.fyilmaz.template.features.main.presenter

import android.view.View
import com.fyilmaz.data.remote.response.anime.AnimeList
import com.fyilmaz.template.R
import com.fyilmaz.template.core.base.BaseFragment
import com.fyilmaz.template.core.common.PageName
import com.fyilmaz.template.core.extensions.observeEvent
import com.fyilmaz.template.core.extensions.observeLiveData
import com.fyilmaz.template.databinding.FragmentMainBinding
import com.fyilmaz.template.features.main.domain.MainViewEvent
import com.fyilmaz.template.features.main.domain.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(
    layoutId = R.layout.fragment_main,
    viewModelClass = MainViewModel::class.java
) {

    override fun getDeepLinkName(): String = PageName.MAIN

    private fun onViewEvent(event: MainViewEvent) {
        when (event) {
            is MainViewEvent.NavigateToDetails -> {
                println(event.item.id)
            }
        }
    }

    override fun onInitDataBinding() {
        observeEvent(viewModel.event, ::onViewEvent)
        binding.viewModel = viewModel
        viewModel.fetchPopulars()
        observed()
    }

    private fun observed() {
        observeLiveData(viewModel.animeList) {
            initData(it)
        }
        observeLiveData(viewModel.loading) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
        observeLiveData(viewModel.baseEvent) {
            onViewEvent(it.peekContent())
        }
    }
    private fun initData(it: AnimeList?) {
        val adapters = AnimeListAdapter(viewModel, it!!)
        binding.recyclerView.apply {
            adapter = adapters
        }
    }
}
