package com.example.lifehackstudio.domain

import com.example.lifehackstudio.domain.model.data.DataCompanyListItem

interface Controller {
    fun openSecondFragment(companyData: DataCompanyListItem)
}