package com.example.lab_3.mvpLR6.ui

import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.restfulManagement.Device

interface MainContract {
    interface View {
        fun displayDevices(devices: List<Device>)
        fun displayError()
    }
    interface Presenter {
        fun loadData()
    }
    interface Repository {
        fun getData(callback: IDataSource.DevicesCallback)
    }
}