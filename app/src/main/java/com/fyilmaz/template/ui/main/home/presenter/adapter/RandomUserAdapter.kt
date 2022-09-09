package com.fyilmaz.template.ui.main.home.presenter.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fyilmaz.template.core.data.dto.user.RandomUsers
import com.fyilmaz.template.core.platform.BaseRecyclerAdapter
import com.fyilmaz.template.ui.main.home.domain.HomeViewModel

class RandomUserAdapter(
    val viewModel: HomeViewModel,
    items: List<RandomUsers.Result>
) : BaseRecyclerAdapter<List<RandomUsers.Result>>(items) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return RandomUserViewHolder(parent, inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RandomUserViewHolder -> {
                holder.bind(viewModel, items[position])
            }
        }
    }
    override fun getItemCount(): Int = items.size
}


