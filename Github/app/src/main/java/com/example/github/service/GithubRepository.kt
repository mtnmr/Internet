package com.example.github.service

import com.example.github.model.Repo
import retrofit2.Response

class GithubRepository {

    suspend fun getReposList(user:String) : Response<List<Repo>> =
        GithubApi.retrofitService.getReposList(user)

    suspend fun getRepo(user:String, repoName:String) : Response<Repo> =
        GithubApi.retrofitService.getRepo(user, repoName)
}