package com.example.mvvmproject.rvadapter.itemviewmodel

import android.graphics.Color
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvvmproject.BR
import com.example.mvvmproject.viewmodel.FirstFragmentViewModel
import com.example.mvvmproject.rvadapter.RvViewModel
import com.example.mvvmproject.R
import java.util.*

class DoubleViewModel(val name: String,
                      @get:Bindable var textColor: Int = Color.BLACK
): BaseObservable(), RvViewModel {
    override val layoutId: Int = R.layout.rv_double_item
    override val viewType: Int = FirstFragmentViewModel.DOUBLE_ITEM

    fun onDoubleClicked() {
        textColor = getRandomColor()
        notifyPropertyChanged(BR.textColor)
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}