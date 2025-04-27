package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.lab_3.databaseManagement.DatabaseTester
import com.example.lab_3.databaseManagement.GeneralDatabase
import com.example.lab_3.databaseManagement.Lab4
import com.example.lab_3.mvpLR6.Lab6
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.mvpLR6.di.DiHelper
import com.example.lab_3.mvpLR6.ui.MainContract
import com.example.lab_3.restfulManagement.Devices
import com.example.lab_3.restfulManagement.Device
import com.example.lab_3.restfulManagement.Lab5
import com.example.lab_3.restfulManagement.TestAPIService

class ChooseDeviceActivity : AppCompatActivity() {
    private var selectedDeviceName: String? = null
    private var selectedDeviceDescription: String? = null
    private var selectedDeviceVersion: String? = null

    fun displayDevices(recyclerView: RecyclerView, devices: List<Device>) {
        recyclerView.adapter = getLab5Adapter(devices)
    }

    private fun addButtons() {
        val buttonBack = findViewById<ImageButton>(R.id.backButton1)
        buttonBack?.setOnClickListener {
            Toast.makeText(this, "Moving back", Toast.LENGTH_SHORT).show()

            val a = Intent(applicationContext, MainActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(a)
        }
        val buttonConnect = findViewById<Button>(R.id.connectButton)
        buttonConnect.setOnClickListener {
            val intent = Intent(this, ConnectingActivity::class.java).apply {
                putExtra("device_name", selectedDeviceName)
                putExtra("device_description", selectedDeviceDescription)
                putExtra("device_version", selectedDeviceVersion)
            }
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_device_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fun displayDevicesHere(devices: List<Device>) {
            displayDevices(recyclerView, devices)
        }

        val lab4: Lab4 = Lab4(applicationContext, recyclerView)
        recyclerView.adapter = getLab4Adapter(lab4.getDeviceInfosSafe())
        lab4.test()

        val lab5: Lab5 = Lab5(applicationContext, recyclerView, ::displayDevicesHere)
        lab5.test()

        val lab6: Lab6 = Lab6(applicationContext, recyclerView, ::displayDevicesHere)
        lab6.test()
        lab6.testRepository()

        // small adjustments
        this.addButtons()
    }

    private fun getLab4Adapter(devices: List<DeviceInfo>) : DeviceAdapter {
        return DeviceAdapter(applicationContext, devices) { selectedDevice ->
            // Store the selected device info
            selectedDeviceName = selectedDevice.name
            selectedDeviceDescription = selectedDevice.description
            selectedDeviceVersion = selectedDevice.version

            // Update UI to show selected device
            println("Selected: ${selectedDevice.name}")
        }
    }
    private fun getLab5Adapter(devices: List<Device>) : DeviceAdapter {
        val deviceInfos = devices.map {
            DeviceInfo(it.name, it.description, it.version)
        }
        return DeviceAdapter(this@ChooseDeviceActivity, deviceInfos) { selectedDevice ->
            selectedDeviceName = selectedDevice.name
            selectedDeviceDescription = selectedDevice.description
            selectedDeviceVersion = selectedDevice.version
            println("Selected: ${selectedDevice.name}")
        }
    }
}