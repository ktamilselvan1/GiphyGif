package com.tamil.assignment.features.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tamil.assignment.base.BaseViewModel
import com.tamil.assignment.data.base.BaseResponse
import com.tamil.assignment.data.repo.gifs.GifRepository
import com.tamil.assignment.data.repo.gifs.response.GifsSearchResponse
import kotlinx.coroutines.*
import javax.inject.Inject

class ProductsViewModel @Inject constructor(private val gifRepository: GifRepository) :
    BaseViewModel() {

    private val _searchGifResponse = MutableLiveData<BaseResponse<GifsSearchResponse?>>()
    val searchGifResponse: LiveData<BaseResponse<GifsSearchResponse?>> = _searchGifResponse

    fun getRandomGif() = liveData(Dispatchers.IO) {
        showLoading()

        val response = gifRepository.randomGif()
        hideLoading()
        when (response.statusCode) {
            200 -> {
                emit(BaseResponse.success(data = response.data))
            }
            else -> {
                emit(
                    BaseResponse.error(
                        data = null,
                        message = response.errorMsg ?: "ERROR",
                        code = response.statusCode
                    )
                )
            }
        }
    }

    fun searchGif(query: String) = liveData(Dispatchers.IO) {
        showLoading()
        val response = gifRepository.searchGif(query)
        when (response.statusCode) {
            200 -> {
                emit(BaseResponse.success(data = response.data))
            }
            else -> {
                emit(
                    BaseResponse.error(
                        data = null,
                        message = response.errorMsg ?: "ERROR",
                        code = response.statusCode
                    )
                )
            }
        }
    }
}