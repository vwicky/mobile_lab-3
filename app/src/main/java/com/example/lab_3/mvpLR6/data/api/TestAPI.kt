package com.example.lab_3.mvpLR6.data.api

import com.example.lab_3.restfulManagement.Devices
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TestAPI {
    @GET("b/67fc03488960c979a5844c9d")
    fun getDevices(@Header("X-MASTER-KEY") secretKey: String): Call<Devices>
}