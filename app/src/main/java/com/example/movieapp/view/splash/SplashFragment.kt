package com.example.movieapp.view.splash

import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSplashBinding
import com.example.movieapp.viewmodel.SplashFViewModel
import com.example.mvvmproject.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment : BaseFragment<FragmentSplashBinding, SplashFViewModel>() {
    private val LOGTAG = "SplashFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_splash

    override val viewModel: SplashFViewModel by viewModel()


    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")
        viewDataBinding.viewModel = viewModel
    }

    override fun initDataBinding() {
        viewModel.count.observe(this, Observer {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSplashSecondFragment())
        })
    }

    override fun initAfterBinding() {
        viewModel.doDelay()
    }

}