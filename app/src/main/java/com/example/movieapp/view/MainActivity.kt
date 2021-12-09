package com.example.movieapp.view

import android.util.Log
import androidx.appcompat.widget.SearchView
import com.example.movieapp.R
import com.example.movieapp.adapter.viewpager.MovieVpAdapter
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.viewmodel.MainAViewModel
import com.example.mvvmproject.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

const val LIST_PAGE_INDEX = 0
const val LIKE_PAGE_INDEX = 1

class MainActivity : BaseActivity<ActivityMainBinding, MainAViewModel>() {
    private val LOGTAG = "MainActivity"
    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainAViewModel by viewModel()

    //뒤로가기 연속 클릭 대기 시간
    var mBackWait:Long = 0

    override fun initStartView() {
        Log.d(LOGTAG, "initStartView")

        viewDataBinding.viewModel = viewModel

        viewDataBinding.viewPager.adapter = MovieVpAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(viewDataBinding.tabLayout, viewDataBinding.viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
        viewDataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 검색 버튼 누를 때 호출
                Log.d(LOGTAG, "onQueryTextSubmit : $query")

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // 검색창에서 글자 변경이 일어날 때마다 호출
                Log.d(LOGTAG, "onQueryTextChange : $newText")

                return true
            }
        })
    }

    // 아이콘 리소스 가져오기
    private fun getTabIcon(position: Int): Int {
        return when (position) {
            LIST_PAGE_INDEX -> R.drawable.list
            LIKE_PAGE_INDEX -> R.drawable.like
            else -> throw IndexOutOfBoundsException()
        }
    }

    // 타이틀 텍스트 가져오기
    private fun getTabTitle(position: Int): String? {
        return when (position) {
            LIST_PAGE_INDEX -> getString(R.string.list_title)
            LIKE_PAGE_INDEX -> getString(R.string.like_title)
            else -> null
        }
    }

    override fun onBackPressed() {
        // 뒤로가기 버튼 클릭
        if(!viewDataBinding.searchView.isIconified) {
            viewDataBinding.searchView.isIconified = true
        }
        else {
            if (System.currentTimeMillis() - mBackWait >= 2000) {
                mBackWait = System.currentTimeMillis()
                Snackbar.make(
                    viewDataBinding.root,
                    "뒤로가기 버튼을 한번 더 누르면 종료됩니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                finish() //액티비티 종료
            }
        }
    }
}