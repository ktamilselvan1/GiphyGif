package com.tamil.assignment.data.repo.gifs

import com.tamil.assignment.data.base.ResponseData
import com.tamil.assignment.data.repo.gifs.response.GifsSearchResponse
import com.tamil.assignment.data.repo.gifs.response.RandomGifResponse

interface GifRepository {
    suspend fun searchGif(searchQuery: String): ResponseData<GifsSearchResponse>
    suspend fun randomGif(): ResponseData<RandomGifResponse>
}