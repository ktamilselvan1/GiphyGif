package com.tamil.assignment.data.repo.gifs.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomGifResponse(
    val data: GifData?,
    val meta: GifMetaData?
) : Parcelable