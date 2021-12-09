package com.example.mvvmproject.rvadapter

sealed class RvItemEvent {
    data class ShowSelected(val name: String): RvItemEvent()
}
