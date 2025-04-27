package com.example.lab_3.mvpLR6

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.ILab
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.mvpLR6.ui.MainContract
import com.example.lab_3.restfulManagement.Device

class Lab6(
    val applicationContext: Context,
    val recyclerView: RecyclerView,
    val displayDevices: (List<Device>) -> Unit
): ILab {
    override fun test() {
        val service = DiHelper.getService()
        service.loadData(object : IDataSource.DevicesCallback {
            override fun onSuccess(devices: List<Device>) {
                displayDevices(devices)
            }
            override fun onFailure() {
                Toast.makeText(
                    applicationContext,
                    "Failed to load devices from API", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun testRepository() {
        val repository: MainContract.Repository = DiHelper.getRepository(
            applicationContext = applicationContext
        )
        repository.getData(object : IDataSource.DevicesCallback {
            override fun onSuccess(devices: List<Device>) {
                displayDevices(devices)
            }
            override fun onFailure() {
                Toast.makeText(
                    applicationContext,
                    "Failed to load devices from API", Toast.LENGTH_LONG).show()
            }
        })
    }
}