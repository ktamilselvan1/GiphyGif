package com.tamil.assignment.di.utils

object BaseConfig {

    val currentEnvironment = Environment.DEV

    val apiKey = "0xtqzWylTldOIs21wftvePdNU9zCuVCZ"

    enum class Environment {
        PROD,
        DEV
    }
}

object NetworkConfig {
    fun getBaseUrl(environment: BaseConfig.Environment): String {
        return when (environment) {
            BaseConfig.Environment.PROD -> TODO()
            BaseConfig.Environment.DEV -> "https://api.giphy.com/v1/"
        }
    }
}