package com.tamil.assignment.data.repo.gifs.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GifsSearchResponse(
    val data: List<GifData>?,
    val meta: GifMetaData?,
    val pagination: Pagination?
) : Parcelable {

    @Parcelize
    data class Pagination(
        val count: Int?,
        val offset: Int?,
        val total_count: Int?
    ) : Parcelable
}