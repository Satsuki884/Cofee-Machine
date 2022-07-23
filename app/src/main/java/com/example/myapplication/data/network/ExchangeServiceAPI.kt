package com.example.myapplication.data.network

import retrofit2.http.GET
import retrofit2.http.Path


interface ExchangeServiceAPI {

    @GET("pair/{exchange}")
    fun exchangeCurrency(@Path("exchange") exchangeInfo: String): NetworkPayment
}
