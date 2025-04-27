package com.example.lab_3.mvpLR6.data

import com.example.lab_3.mvpLR6.data.api.RetrofitAPIHelper
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.restfulManagement.Device
import com.example.lab_3.restfulManagement.Devices
import com.example.lab_3.restfulManagement.TestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestAPIService : IDataSource {
    var api: TestAPI

    init {
        api = DiHelper.getRetrofitHelper().retrofit!!.create(TestAPI::class.java)
    }

    val SECRET_KEY = "\$2a\$10\$yf58PLHGVa3BZxsCCkkSi.G4H16jXjuNXyhjtEJgShrMMOKaOmY3a"

    override fun loadData(callback: IDataSource.DevicesCallback) {
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
}