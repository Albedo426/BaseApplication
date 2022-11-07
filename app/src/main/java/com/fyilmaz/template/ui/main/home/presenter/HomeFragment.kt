package com.fyilmaz.template.ui.main.home.presenter

import android.util.Log
import com.fyilmaz.template.R
import com.fyilmaz.template.core.common.PageName
import com.fyilmaz.template.core.extensions.observe
import com.fyilmaz.template.core.extensions.observeEvent
import com.fyilmaz.template.core.platform.BaseFragment
import com.fyilmaz.template.databinding.FragmentHomeBinding
import com.fyilmaz.template.ui.main.home.domain.HomeViewEvent
import com.fyilmaz.template.ui.main.home.domain.HomeViewModel
import com.fyilmaz.template.ui.main.home.presenter.adapter.RandomUserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutId = R.layout.fragment_home,
    viewModelClass = HomeViewModel::class.java
) {


    private lateinit var userAdapter: RandomUserAdapter
    override fun getScreenKey(): String {
        return PageName.Main.home
    }

    override fun onDataBinding() {
        binding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)
        initAdapters()
        initObserve()
    }

    private fun initObserve() {
        observe(viewModel.userList) {
            userAdapter.updateData(it.results)
        }
    }

    private fun initAdapters() {
        userAdapter = RandomUserAdapter(viewModel, listOf())
        binding.recyclerView.adapter = userAdapter
    }

    private fun onViewEvent(event: HomeViewEvent) {
        when (event) {
        }
    }
}
