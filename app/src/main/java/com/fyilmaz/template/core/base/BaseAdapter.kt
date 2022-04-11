package com.fyilmaz.template.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T>(
    open var list: List<T>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    abstract fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        onCreateViewHolder(
            parent = parent,
            inflater = LayoutInflater.from(parent.context),
            viewType = viewType
        )
    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}
