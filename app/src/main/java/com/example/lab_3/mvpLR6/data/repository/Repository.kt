package com.example.lab_3.mvpLR6.data.repository

import com.example.lab_3.databaseManagement.GeneralDatabase
import com.example.lab_3.databaseManagement.entities.DeviceEntity
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.mvpLR6.data.TestAPIService
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.mvpLR6.ui.MainContract
import com.example.lab_3.restfulManagement.Device
import com.example.lab_3.restfulManagement.Devices

class Repository(
    private val apiService: IDataSource,
    private val database: GeneralDatabase
) : MainContract.Repository {
    override fun getData(callback: IDataSource.DevicesCallback) {
        apiService.loadData(object : IDataSource.DevicesCallback {
            override fun onSuccess(devices: List<Device>) {
                // Save to DB
                val entities = devices.map { DeviceTranslator.deviceToEntity(it) }
                database.devicesDao().insertAll(entities)
                // Return original devices to caller
                callback.onSuccess(devices)
            }
            override fun onFailure() {
                // Load from DB if network failed
                val devicesFromDb = database.devicesDao().getAll()
                val devices = devicesFromDb.map { DeviceTranslator.entityToDevice(it) }
                if (devices.isNotEmpty()) {
                    callback.onSuccess(devices)
                } else {
                    callback.onFailure()
                }
            }
        })
    }
}
