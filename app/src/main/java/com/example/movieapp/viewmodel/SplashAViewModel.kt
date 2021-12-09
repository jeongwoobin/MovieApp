package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.base.BaseViewModel

class SplashAViewModel: BaseViewModel() {
    private val LOGTAG = "SplashAViewModel"

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

}