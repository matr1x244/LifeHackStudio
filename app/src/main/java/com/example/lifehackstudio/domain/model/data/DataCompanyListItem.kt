package com.example.lifehackstudio.domain.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataCompanyListItem(
    val id: String?,
    val img: String?,
    val name: String?
): Parcelable