package com.tamil.assignment.data.network

class ApiHelper(private val apiService: ApiService) {
    suspend fun searchGif(query: String) = apiService.searchGif(query)
    suspend fun getRandomGif() = apiService.getRandomGif()
}