package com.apkdoandroid.fakestorecomteste.data.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun retrofitClient() : FakeStoreAPI {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeStoreAPI::class.java)
    }
}