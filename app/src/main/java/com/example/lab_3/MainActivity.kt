package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonChooseDevice = findViewById<Button>(R.id.button)
        buttonChooseDevice?.setOnClickListener {
            Toast.makeText(this, "Moving to Choosing Device...", Toast.LENGTH_SHORT).show()

            val a = Intent(applicationContext, ChooseDeviceActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(a)
        }

        val buttonConnecting = findViewById<Button>(R.id.button2)
        buttonConnecting?.setOnClickListener {
            Toast.makeText(this, "Moving to Connecting...", Toast.LENGTH_SHORT).show()

            val a = Intent(applicationContext, ConnectingActivity::class.java)
            a.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(a)
        }
    }
}
