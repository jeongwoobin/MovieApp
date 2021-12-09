package com.example.mvvmproject.rvadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

class BindableRvAdapter: RecyclerView.Adapter<BindableViewHolder>() {
    private val LOGTAG = "BindableRvAdapter"

    private var itemViewModels: List<RvViewModel> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            viewTypeToLayoutId[viewType] ?: 0,
            viewGroup,
            false
        )
        return BindableViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemViewModels[position]
        if(!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun getItemCount(): Int = itemViewModels.size


    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
    }

    fun setData(items: List<RvViewModel>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }
}

class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: RvViewModel) {
        binding.setVariable(BR.viewModel, itemViewModel)
    }
}