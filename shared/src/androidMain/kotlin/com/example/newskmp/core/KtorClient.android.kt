package com.example.newskmp.core

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.defaultRequest

class AndroidKtorClient: KtorClient{
    override fun provideKtorClient(): HttpClient {
        return HttpClient(OkHttp){
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
    return AndroidKtorClient()
}