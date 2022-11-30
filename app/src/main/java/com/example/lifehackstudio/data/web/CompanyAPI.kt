package com.example.lifehackstudio.data.web

import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem
import retrofit2.http.GET
import retrofit2.http.Query

interface CompanyAPI {

    @GET("test.php")
    suspend fun listCompany(): List<DataCompanyListItem>

    @GET("test.php") //https://lifehack.studio/test_task/test.php?id=1
    suspend fun detailCompany(
        @Query("id") id: String?
    ): List<DataCompanyDetailItem>

}