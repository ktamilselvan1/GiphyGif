package com.tamil.assignment.data.repo.gifs

import com.tamil.assignment.data.base.ResponseData
import com.tamil.assignment.data.network.ApiHelper
import com.tamil.assignment.data.repo.gifs.response.GifsSearchResponse
import com.tamil.assignment.data.repo.gifs.response.RandomGifResponse

class GifRepositoryImpl(private val apiHelper: ApiHelper) : GifRepository {

    override suspend fun searchGif(searchQuery: String): ResponseData<GifsSearchResponse> {
        val response = apiHelper.searchGif(searchQuery)
        return if (response.isSuccessful) {
            ResponseData(response.body(), response.code(), response.message())
        } else {
            ResponseData(null, response.code(), response.message())
        }
    }

    override suspend fun randomGif(): ResponseData<RandomGifResponse> {
        val response = apiHelper.getRandomGif()
        return if (response.isSuccessful) {
            ResponseData(response.body(), response.code(), response.message())
        } else {
            ResponseData(null, response.code(), response.message())
        }
    }

}