package com.example.lifehackstudio.domain.model

import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem

interface RepositoryCompany {
    suspend fun observerListCompany(): List<DataCompanyListItem>

    suspend fun getDetailCompany(id: String?): List<DataCompanyDetailItem>
}