package com.example.lifehackstudio.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: RepositoryCompany) : ViewModel() {

    private val _repos = MutableLiveData<List<DataCompanyItem>>()
    val repos: LiveData<List<DataCompanyItem>> = _repos


    fun onShowList() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "No success $throwable")
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.observerListCompany()
            withContext(Dispatchers.Main) {
                _repos.postValue(result)
            }
        }
    }
}