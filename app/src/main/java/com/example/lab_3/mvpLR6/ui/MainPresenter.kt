package com.example.lab_3.mvpLR6.ui

import android.util.Log
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.restfulManagement.Device
import com.example.lab_3.restfulManagement.TestAPIService

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    val service: IDataSource = DiHelper.getService()

    override fun loadData() {
        Log.d("API", "loadData")
        //val service = IDataSource()
        service.loadData(object : IDataSource.DevicesCallback {
            override fun onSuccess(devices: List<Device>) {
                view.displayDevices(devices)
            }
            override fun onFailure() {
                view.displayError()
            }
        })
    }
}