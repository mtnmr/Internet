package com.example.github.viewmodel

import androidx.lifecycle.*
import com.example.github.model.Repo
import com.example.github.service.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException

class DetailViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _repo = MutableLiveData<Repo>()
    val repo:LiveData<Repo> = _repo

    private fun getRepo(user:String, repoName:String){
        viewModelScope.launch {
            try {
                val response = repository.getRepo(user, repoName)
                if ( response.isSuccessful){
                    _repo.value = response.body()
                }
            }catch(e:Exception){
                //エラーの処理いる？
            }
        }
    }
}

class DetailViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(repository) as T
        }
        throw (IllegalArgumentException("Unknown ViewModel Class"))
    }
}