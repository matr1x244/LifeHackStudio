package com.example.lifehackstudio.data.web

import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem

class RetrofitRequestImpl(private val api: CompanyAPI) : RepositoryCompany {

    override suspend fun observerListCompany(): List<DataCompanyListItem> {
        return api.listCompany()
    }

    override suspend fun getDetailCompany(id: String?): List<DataCompanyDetailItem> {
        return api.detailCompany(id)
    }
}