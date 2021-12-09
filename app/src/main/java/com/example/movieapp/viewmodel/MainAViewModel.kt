package com.example.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.base.BaseViewModel

class MainAViewModel: BaseViewModel() {
    private val LOGTAG = "MainAViewModel"

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

}