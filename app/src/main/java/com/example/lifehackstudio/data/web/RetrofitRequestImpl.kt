package com.example.lifehackstudio.data.web

import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem


class RetrofitRequestImpl(private val api: CompanyAPI) : RepositoryCompany {

    override suspend fun observerListCompany(): List<DataCompanyListItem> {
        return api.listCompany()
    }

    override suspend fun getDetailCompany(id: String?): DataCompanyDetailItem {
        val dto = api.detailCompany(id).execute().body()
        return DataCompanyDetailItem(
            id = dto?.id,
            img = dto?.img,
            name = dto?.name,
            description = dto?.description
        )
    }
}