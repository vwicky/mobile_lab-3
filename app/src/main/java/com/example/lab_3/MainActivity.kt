package com.example.lab_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.lab_3.databaseManagement.DatabaseTester
import com.example.lab_3.databaseManagement.GeneralDatabase
import com.example.lab_3.mvpLR6.ui.MainActivity
import com.example.lab_3.restfulManagement.Device
import com.example.lab_3.restfulManagement.Devices
import com.example.lab_3.restfulManagement.TestAPI
import com.example.lab_3.restfulManagement.TestAPIService

class MainActivity : AppCompatActivity() {
    lateinit var db: GeneralDatabase
    lateinit var dbTester: DatabaseTester

    var mainActivity: MainActivity = MainActivity()

    private fun createDB() {
        db = Room.databaseBuilder(
            applicationContext,
            GeneralDatabase::class.java, "general-database"
        ).allowMainThreadQueries().build()
        dbTester = DatabaseTester(db)
    }
    private fun testDB() {
        dbTester.testDB()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // LR 4-5
        //loadData()
        //createDB()
        //testDB()

        mainActivity.presenter.loadData()

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
