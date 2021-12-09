package com.example.movieapp.view.splash

import android.annotation.SuppressLint
import android.util.Log
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivitySplashBinding
import com.example.movieapp.viewmodel.SplashAViewModel
import com.example.mvvmproject.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashAViewModel>() {
    private val LOGTAG = "SplashActivity"
    override val layoutResourceId: Int
        get() = R.layout.activity_splash

    override val viewModel: SplashAViewModel by viewModel()

    //뒤로가기 연속 클릭 대기 시간
    var mBackWait:Long = 0

    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")
        viewDataBinding.viewModel = viewModel
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }

    override fun onBackPressed() {
        // 뒤로가기 버튼 클릭
        if(System.currentTimeMillis() - mBackWait >=2000 ) {
            mBackWait = System.currentTimeMillis()
            Snackbar.make(viewDataBinding.root, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Snackbar.LENGTH_SHORT).show()
        } else {
            finish() //액티비티 종료
        }
    }
}