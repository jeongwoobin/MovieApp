package com.example.movieapp.view

import android.util.Log
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieLikeBinding
import com.example.movieapp.viewmodel.MovieLikeFViewModel
import com.example.mvvmproject.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieLikeFragment : BaseFragment<FragmentMovieLikeBinding, MovieLikeFViewModel>() {
    private val LOGTAG = "MovieLikeFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_movie_like

    override val viewModel: MovieLikeFViewModel by viewModel()

    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")
        viewDataBinding.viewModel = viewModel
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

}