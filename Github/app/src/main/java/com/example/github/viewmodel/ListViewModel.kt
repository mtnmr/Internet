package com.example.github.viewmodel

import androidx.lifecycle.*
import com.example.github.R
import com.example.github.model.Repo
import com.example.github.service.GithubRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException

class ListViewModel(private val repository: GithubRepository) : ViewModel() {

    private var _repoList = MutableLiveData<List<Repo>>()
    val repoList : LiveData<List<Repo>> = _repoList

    init {
//        getRepoList(R.string.github_user_name.toString())
        getRepoList("mtnmr")
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
}


class ListViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ListViewModel(repository) as T
        }
        throw (IllegalArgumentException("Unknown ViewModel Class"))
    }
}