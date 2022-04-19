package com.example.github.service

import com.example.github.model.Repo
import retrofit2.Response

class GithubRepository {

    suspend fun getReposList(user:String) : List<Repo> =
        GithubApi.retrofitService.getReposList(user)

    suspend fun getRepo(user:String, repoName:String) : Repo =
        GithubApi.retrofitService.getRepo(user, repoName)
}