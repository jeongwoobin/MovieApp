package com.example.movieapp.model

import com.example.mvvmproject.model.service.ApiService
import io.reactivex.Single
import retrofit2.Response

class DataModelImpl(private val service: ApiService) : DataModel {
    override fun getGitRepos(): Single<Response<String>> {
        return service.getGitRepos()
    }

}