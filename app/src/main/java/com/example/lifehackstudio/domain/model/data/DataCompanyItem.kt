package com.example.lifehackstudio.domain.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataCompanyItem(
    val id: String?,
    val img: String?,
    val name: String?
): Parcelable