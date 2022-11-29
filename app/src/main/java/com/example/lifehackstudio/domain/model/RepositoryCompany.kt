package com.example.lifehackstudio.domain.model

import com.example.lifehackstudio.domain.model.data.DataCompanyItem


interface RepositoryCompany {
    suspend fun observerListCompany(): List<DataCompanyItem>
}