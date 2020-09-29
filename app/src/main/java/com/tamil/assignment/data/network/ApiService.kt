package com.tamil.assignment.data.network

import com.tamil.assignment.data.repo.gifs.response.GifsSearchResponse
import com.tamil.assignment.data.repo.gifs.response.RandomGifResponse
import com.tamil.assignment.di.utils.BaseConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/search")
    suspend fun searchGif(
        @Query("q") queryString: String,
        @Query("api_key") apiKey: String = BaseConfig.apiKey
    ): Response<GifsSearchResponse>

    @GET("gifs/random")
    suspend fun getRandomGif(
        @Query("api_key") apiKey: String = BaseConfig.apiKey
    ): Response<RandomGifResponse>
}