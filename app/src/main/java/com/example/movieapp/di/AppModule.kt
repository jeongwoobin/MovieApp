package com.example.mvvmproject.di

import com.example.movieapp.model.DataModel
import com.example.movieapp.model.DataModelImpl
import com.example.movieapp.viewmodel.*
import com.example.mvvmproject.model.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

var retrofitPart = module {
    single(name = "string") {
        val BASE_URL = "https://yts.mx/api/v2/list_movies.json"
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get("string"))
    }
}

var viewModelPart = module {
    viewModel {
        SplashAViewModel()
    }
    viewModel {
        SplashFViewModel()
    }
    viewModel {
        SplashSecondFViewModel()
    }
    viewModel {
        MainAViewModel()
    }
    viewModel {
        MovieListFViewModel()
    }
    viewModel {
        MovieLikeFViewModel()
    }
}

var myDiModule = listOf(retrofitPart, modelPart, viewModelPart)