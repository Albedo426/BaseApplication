package com.fyilmaz.template.features.main.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fyilmaz.data.remote.response.anime.AnimeList
import com.fyilmaz.template.core.base.BaseListAdapter
import com.fyilmaz.template.core.base.BaseViewHolder
import com.fyilmaz.template.databinding.ItemAnimeInListBinding
import com.fyilmaz.template.features.main.domain.MainViewModel

class AnimeListAdapter(
    val viewModel: MainViewModel,
    list: AnimeList?
) : BaseListAdapter<AnimeList.Anime>(list!!.animeList) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return AnimeListViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AnimeListViewHolder -> {
                list?.get(position)?.let { holder.bind(viewModel, it) }
            }
        }
    }
}

class AnimeListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder<ItemAnimeInListBinding>(
        binding = ItemAnimeInListBinding.inflate(inflater, parent, false)
    ) {
    fun bind(
        viewModels: MainViewModel,
        items: AnimeList.Anime
    ) {
        binding.apply {
            anime = items
            viewModel = viewModels
            executePendingBindings()
        }
    }
}
