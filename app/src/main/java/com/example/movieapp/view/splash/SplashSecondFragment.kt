package com.example.movieapp.view.splash

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSplashSecondBinding
import com.example.movieapp.view.MainActivity
import com.example.movieapp.viewmodel.SplashSecondFViewModel
import com.example.mvvmproject.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashSecondFragment : BaseFragment<FragmentSplashSecondBinding, SplashSecondFViewModel>() {
    private val LOGTAG = "SplashSecondFragment"

    override val layoutResourceId: Int
        get() = R.layout.fragment_splash_second

    override val viewModel: SplashSecondFViewModel by viewModel()


    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")
        viewDataBinding.viewModel = viewModel
    }

    override fun initDataBinding() {
        viewModel.count.observe(this, Observer {
            viewDataBinding.btnGo.visibility = View.VISIBLE
        })
    }

    override fun initAfterBinding() {
        viewModel.doDelay()
        viewDataBinding.btnGo.setOnClickListener {
            startActivity(Intent(mContext, MainActivity::class.java))
            requireActivity().finish()
        }
    }
}