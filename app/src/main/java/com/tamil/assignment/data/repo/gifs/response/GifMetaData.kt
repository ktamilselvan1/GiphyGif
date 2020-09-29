package com.tamil.assignment.data.repo.gifs.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GifMetaData(
    val msg: String?,
    val response_id: String?,
    val status: Int?
) : Parcelable