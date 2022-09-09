package com.fyilmaz.template.ui.main.home.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import com.fyilmaz.template.core.platform.BaseViewHolder
import com.fyilmaz.template.databinding.ViewholderHomeUserItemBinding
import com.fyilmaz.template.ui.main.home.domain.HomeViewModel

class RandomUserViewHolder(
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ViewholderHomeUserItemBinding>(
    binding = ViewholderHomeUserItemBinding.inflate(inflater, parent, false)
) {
    fun bind(viewModel: HomeViewModel, item: RandomUsers.Result) {
        binding.userItemUiState = item
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
