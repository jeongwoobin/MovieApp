package com.example.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.base.BaseViewModel

class MovieListFViewModel: BaseViewModel() {
    private val LOGTAG = "MovieListFViewModel"

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

}