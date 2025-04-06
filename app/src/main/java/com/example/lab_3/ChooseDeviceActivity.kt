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

val mockDevices = listOf(
    DeviceInfo("Lorem Ipsum 1", "lorem 11 ipsum dorem", "Version 01.0.01V"),
    DeviceInfo("Lorem Ipsum 2", "lorem 22 ipsum dorem", "Version 02.0.01V"),
    DeviceInfo("Lorem Ipsum 3", "lorem 33 ipsum dorem", "Version 03.0.01V"),
    DeviceInfo("Lorem Ipsum 4", "lorem 44 ipsum dorem", "Version 04.0.01V"),
    DeviceInfo("Lorem Ipsum 5", "lorem 55 ipsum dorem", "Version 05.0.01V"),
);

class ChooseDeviceActivity : AppCompatActivity() {
    private var selectedDeviceName: String? = null
    private var selectedDeviceDescription: String? = null
    private var selectedDeviceVersion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_device_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        val customAdapter = DeviceAdapter(this, mockDevices) { selectedDevice ->
            // Store the selected device info
            selectedDeviceName = selectedDevice.name
            selectedDeviceDescription = selectedDevice.description
            selectedDeviceVersion = selectedDevice.version

            // Update UI to show selected device
            println("Selected: ${selectedDevice.name}")
            //findViewById<TextView>(R.id.selectedDeviceText).text = "Selected: ${selectedDevice.name}"
        }

        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

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
}