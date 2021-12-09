package com.example.mvvmproject.rvadapter.itemviewmodel

import androidx.databinding.BaseObservable
import com.example.mvvmproject.R
import com.example.mvvmproject.rvadapter.RvViewModel
import com.example.mvvmproject.viewmodel.FirstFragmentViewModel

class SingleViewModel(val name: String, private val onItemClicked: (String) -> Unit): BaseObservable(), RvViewModel {
    override val layoutId: Int = R.layout.rv_single_item
    override val viewType: Int = FirstFragmentViewModel.SINGLE_ITEM

    fun onSingleClicked() {
        onItemClicked("$name is Clicked")
    }
}