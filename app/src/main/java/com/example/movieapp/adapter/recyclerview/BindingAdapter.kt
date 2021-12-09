package com.example.mvvmproject.rvadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<RvViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.setData(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRvAdapter {
    return if(recyclerView.adapter != null && recyclerView.adapter is BindableRvAdapter) {
        recyclerView.adapter as BindableRvAdapter
    } else {
        val bindableRvAdapter = BindableRvAdapter()
        recyclerView.adapter = bindableRvAdapter
        bindableRvAdapter
    }
}