package com.example.movieapp

import android.app.Application
import com.example.mvvmproject.di.myDiModule
import org.koin.android.ext.android.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}