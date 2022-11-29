package com.example.lifehackstudio.data.web

import com.example.lifehackstudio.domain.model.data.DataCompanyItem
import retrofit2.http.GET
import retrofit2.http.POST

interface CompanyAPI {

    @POST("test.php")
    suspend fun listCompany(): List<DataCompanyItem>

}