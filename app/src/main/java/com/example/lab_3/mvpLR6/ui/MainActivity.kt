package com.example.lab_3.mvpLR6.ui

import android.util.Log
import android.widget.Toast
import com.example.lab_3.MainActivity
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.restfulManagement.Device

class MainActivity : MainContract.View {
    var presenter: MainContract.Presenter = DiHelper.getPresenter(this)

    override fun displayDevices(devices: List<Device>) {
        for (device in devices) {
            Log.d("API", device.name)
            Log.d("API", device.description)
            Log.d("API", device.version)
        }
    }

    override fun displayError() {
        Log.d("API", "error loading data")
        //Toast.makeText(MainActivity, "loading failed", Toast.LENGTH_LONG).show()
    }

}