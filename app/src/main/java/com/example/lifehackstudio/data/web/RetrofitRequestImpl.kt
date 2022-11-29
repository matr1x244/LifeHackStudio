package com.example.lifehackstudio.data.web

import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyItem


class RetrofitRequestImpl(private val api: CompanyAPI) : RepositoryCompany {

    override suspend fun observerListCompany(): List<DataCompanyItem> {
        return api.listCompany()
    }

}