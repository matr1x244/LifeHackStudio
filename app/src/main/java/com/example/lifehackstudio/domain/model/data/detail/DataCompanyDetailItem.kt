package com.example.lifehackstudio.domain.model.data.detail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataCompanyDetailItem(
    val id: String?,
    val img: String?,
    val name: String?,
    val description: String?,
//    val phone: String?,
//    val www: String?
): Parcelable