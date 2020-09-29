package com.tamil.assignment.data.base

data class BaseResponse<out ResponseData>(
    val status: Status,
    val data: ResponseData?,
    val message: String?,
    val statusCode: Int?
) {
    companion object {
        fun <T> success(data: T): BaseResponse<T> =
            BaseResponse(status = Status.SUCCESS, data = data, message = null, statusCode = null)

        fun <T> error(data: T?, message: String, code: Int): BaseResponse<T> =
            BaseResponse(status = Status.ERROR, data = data, message = message, statusCode = code)

        fun <T> loading(data: T?): BaseResponse<T> =
            BaseResponse(status = Status.LOADING, data = data, message = null, statusCode = null)
    }
}