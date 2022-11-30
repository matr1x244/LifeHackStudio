package com.example.lifehackstudio.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import kotlinx.coroutines.*

class MainViewModel(private val repository: RepositoryCompany) : ViewModel() {

    private val _repos = MutableLiveData<List<DataCompanyListItem>>()
    val repos: LiveData<List<DataCompanyListItem>> = _repos

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun onShowList() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "No success $throwable")
        }
        coroutineScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.observerListCompany()
            withContext(Dispatchers.Main) {
                _repos.postValue(result)
            }
        }
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}