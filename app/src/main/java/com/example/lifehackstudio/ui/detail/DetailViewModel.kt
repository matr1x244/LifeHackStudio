package com.example.lifehackstudio.ui.detail

import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val repository: RepositoryCompany) : ViewModel() {

    private val _repos = MutableLiveData<DataCompanyDetailItem>()
    val repos: LiveData<DataCompanyDetailItem> = _repos

    fun onShowCompany(id: String?) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "No success $throwable")
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.getDetailCompany(id)
            withContext(Dispatchers.Main) {
                _repos.postValue(result)
            }
        }
    }

}