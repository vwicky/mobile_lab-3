package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConnectingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connecting_activity)

        // Retrieve device details from Intent extras
        val deviceName = intent.getStringExtra("device_name") ?: "Unknown Device"
        val deviceDescription = intent.getStringExtra("device_description") ?: "No Description"
        val deviceVersion = intent.getStringExtra("device_version") ?: "Unknown Version"

        // Find TextViews
        val nameText = findViewById<TextView>(R.id.textView_name)
        val descriptionText = findViewById<TextView>(R.id.textView_description)
        val versionText = findViewById<TextView>(R.id.textView_version)

        // Set the values dynamically
        nameText.text = deviceName
        descriptionText.text = deviceDescription
        versionText.text = deviceVersion

        // Back button functionality
        val buttonBack = findViewById<ImageButton>(R.id.backButton2)
        buttonBack?.setOnClickListener {
            Toast.makeText(this, "Moving back", Toast.LENGTH_SHORT).show()

            val a = Intent(applicationContext, MainActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(a)
        }
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)
        buttonCancel?.setOnClickListener {
            Toast.makeText(this, "Moving back", Toast.LENGTH_SHORT).show()

            val a = Intent(applicationContext, ChooseDeviceActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(a)
        }
    }
}
