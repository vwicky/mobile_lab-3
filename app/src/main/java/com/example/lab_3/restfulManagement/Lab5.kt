package com.example.lab_3.restfulManagement

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.DeviceInfo
import com.example.lab_3.ILab

class Lab5(
    val applicationContext: Context,
    val recyclerView: RecyclerView,
    val displayDevices: (List<Device>) -> Unit
) : ILab {
    var devices: List<Device>? = null

    fun getDevicesSafe(): List<Device> {
        if (devices == null) {
            this.test()
        }
        return devices ?: emptyList() // Return empty list if devices are still null
    }
    override fun test() {
        val service = TestAPIService()
        service.getDevices(object : TestAPIService.DevicesCallback {
            override fun onSuccess(devicesLoaded: List<Device>) {
                devices = devicesLoaded
                displayDevices(devicesLoaded)
            }
            override fun onFailure() {
                Toast.makeText(applicationContext,
                    "Failed to load devices from API", Toast.LENGTH_LONG).show()
                devices = null
            }
        })
    }
}
