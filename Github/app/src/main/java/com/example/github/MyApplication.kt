package com.example.github

import android.app.Application
import com.example.github.service.GithubRepository

class MyApplication:Application() {

    val repository: GithubRepository by lazy {
        GithubRepository.getRepository()
    }
}