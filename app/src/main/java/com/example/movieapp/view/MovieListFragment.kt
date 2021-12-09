package com.example.movieapp.view

import android.util.Log
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieListBinding
import com.example.movieapp.viewmodel.MovieListFViewModel
import com.example.mvvmproject.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment<FragmentMovieListBinding, MovieListFViewModel>() {
    private val LOGTAG = "MovieListFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_movie_list

    override val viewModel: MovieListFViewModel by viewModel()

    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")
        viewDataBinding.viewModel = viewModel
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

}