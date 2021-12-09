package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmproject.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashSecondFViewModel: BaseViewModel() {
    private val LOGTAG = "SplashSecondFViewModel"

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    fun doDelay() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            _count.postValue(2)

        }
    }
}