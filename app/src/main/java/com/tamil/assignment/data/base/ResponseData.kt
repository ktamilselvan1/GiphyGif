package com.tamil.assignment.data.base

class ResponseData<out T>(
    val data: T?,
    val statusCode: Int,
    val errorMsg: String?
)