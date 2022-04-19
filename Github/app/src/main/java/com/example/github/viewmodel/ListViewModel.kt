package com.example.github.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.github.R
import com.example.github.model.Repo
import com.example.github.service.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException

class ListViewModel(private val repository: GithubRepository, private val context: Context) : ViewModel() {

    private var _repoList = MutableLiveData<List<Repo>>()
    val repoList : LiveData<List<Repo>> = _repoList

    init {
//        getRepoList(R.string.github_user_name.toString())
//        getRepoList("mtnmr")
        getRepoList(context.applicationContext.getString(R.string.github_user_name))
    }

    private fun getRepoList(user :String){
        viewModelScope.launch {
            try {
                _repoList.value = repository.getReposList(user)
            }catch (e:Exception){
                _repoList.value = listOf()
                //エラー処理いる？
            }
        }
    }



    private val _repo = MutableLiveData<Repo>()
    val repo:LiveData<Repo> = _repo

    fun getRepo(user:String, repoName:String){
        viewModelScope.launch {
            try {
                _repo.value = repository.getRepo(user, repoName)
            }catch(e:Exception){
                //エラーの処理いる？
            }
        }
    }


    fun onRepoClick(repo : Repo){
        _repo.value = repo
    }

}


class ListViewModelFactory(private val repository: GithubRepository, private val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ListViewModel(repository, context) as T
        }
        throw (IllegalArgumentException("Unknown ViewModel Class"))
    }
}