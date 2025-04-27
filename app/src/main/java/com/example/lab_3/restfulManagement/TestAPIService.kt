package com.example.lab_3.restfulManagement

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestAPIService {
    var api: TestAPI
    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io/v3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(TestAPI::class.java)
    }

    val SECRET_KEY = "\$2a\$10\$yf58PLHGVa3BZxsCCkkSi.G4H16jXjuNXyhjtEJgShrMMOKaOmY3a"
    fun getDevices(callback: DevicesCallback) {
        api.getDevices(SECRET_KEY).enqueue(object : Callback<Devices> {
            override fun onResponse(call: Call<Devices>, response: Response<Devices>) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!.record.devices)
                else
                    callback.onFailure()
            }
            override fun onFailure(call: Call<Devices>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
    interface DevicesCallback {
        fun onSuccess(devices: List<Device>)
        fun onFailure()
    }
}