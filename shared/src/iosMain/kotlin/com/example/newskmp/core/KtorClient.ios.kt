package com.example.newskmp.core

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.defaultRequest

class IosKtorClient: KtorClient{
    override fun provideKtorClient(): HttpClient {
        return HttpClient(Darwin){
            install(DefaultRequest)
            defaultRequest {
                url("https://newsapi.org/"){
                    headers.append("API-KEY", "")
                }
            }
        }
    }
}
actual fun getKtorClient(): KtorClient {
    return IosKtorClient()
}