package com.example.lifehackstudio.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem
import kotlinx.coroutines.*

class DetailViewModel(private val repository: RepositoryCompany) : ViewModel() {

    private val _repos = MutableLiveData<List<DataCompanyDetailItem>>()
    val repos: LiveData<List<DataCompanyDetailItem>> = _repos

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun onShowCompany(id: String?) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "onShowCompany COROUTINE $throwable")
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.getDetailCompany(id)
            Log.v("@@@@", "viewModelScope RESULT $result")
            withContext(Dispatchers.Main) {
                _repos.postValue(result)
                Log.v("@@@@", "viewModelScope POSTVALUE $_repos")
            }
        }
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }

}