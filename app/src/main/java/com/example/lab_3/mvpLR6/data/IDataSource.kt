package com.example.lab_3.mvpLR6.data

import com.example.lab_3.restfulManagement.Device

interface IDataSource {
    fun loadData(callback: DevicesCallback) // : List<Device>

    interface DevicesCallback {
        fun onSuccess(devices: List<Device>)
        fun onFailure()
    }
}