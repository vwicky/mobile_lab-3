package com.example.lab_3.databaseManagement

import android.util.Log
import com.example.lab_3.databaseManagement.entities.DeviceTypeEntity
import com.example.lab_3.databaseManagement.testers.ConnectionLogsTester
import com.example.lab_3.databaseManagement.testers.DeviceTester
import com.example.lab_3.databaseManagement.testers.DeviceTypeTester

class DatabaseTester(val db: GeneralDatabase) {
    val deviceTypeTester = DeviceTypeTester(db.devicesTypeDao())
    val deviceTester = DeviceTester(db.devicesDao())
    val connectionLogsTester = ConnectionLogsTester(db.connectionLogsDao())

    fun testDB() {
        deviceTypeTester.testDB()
        deviceTester.testDB()
        connectionLogsTester.testDB()
    }
}