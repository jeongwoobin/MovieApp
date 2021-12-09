package com.example.mvvmproject.rvadapter

import androidx.annotation.LayoutRes

interface RvViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}