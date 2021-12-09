package com.example.movieapp.model

import io.reactivex.Single
import retrofit2.Response

interface DataModel {
    fun getGitRepos(): Single<Response<String>>
}