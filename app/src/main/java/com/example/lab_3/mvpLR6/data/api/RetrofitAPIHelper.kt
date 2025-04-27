package com.example.lab_3.mvpLR6.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAPIHelper {
    companion object {
        var retrofit: Retrofit? = null

        fun init() {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client: OkHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(logging)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/v3/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
