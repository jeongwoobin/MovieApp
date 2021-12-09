package com.example.movieapp.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieapp.view.MovieLikeFragment
import com.example.movieapp.view.MovieListFragment
import java.lang.IndexOutOfBoundsException

const val LIST_PAGE_INDEX = 0
const val LIKE_PAGE_INDEX = 1

class MovieVpAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    private val fragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        LIST_PAGE_INDEX to { MovieListFragment() },
        LIKE_PAGE_INDEX to { MovieLikeFragment() }
    )

    override fun getItemCount(): Int = fragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}