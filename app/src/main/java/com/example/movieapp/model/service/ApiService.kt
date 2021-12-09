package com.example.mvvmproject.model.service

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    fun getGitRepos(
    ): Single<Response<String>>
}