package com.example.newskmp.core

import io.ktor.client.HttpClient

interface KtorClient {
    fun provideKtorClient(): HttpClient
}

expect fun getKtorClient(): KtorClient