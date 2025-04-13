package com.example.lab_3.databaseManagement.testers

import android.util.Log
import com.example.lab_3.databaseManagement.GeneralDatabase
import com.example.lab_3.databaseManagement.dao.DeviceTypeDAO
import com.example.lab_3.databaseManagement.entities.DeviceTypeEntity

class DeviceTypeTester(val dao: DeviceTypeDAO) {
    private var deviceType1 = DeviceTypeEntity(1, "headphones")
    private var deviceType2 = DeviceTypeEntity(2, "smart-watch")

    private fun writeMessage(message: String) {
        Log.d("TEST", message)
    }
    fun testDB() {
        testInsertDeviceType()
        testReadDeviceType()
        testUpdateDeviceType()
        testDeleteDeviceType()
        testInsertDeviceType()
    }
    private fun testInsertDeviceType() {
        writeMessage("Insert DeviceType")
        dao.insert(deviceType1)
        dao.insert(deviceType2)
    }
    private fun testReadDeviceType() {
        writeMessage("Read DeviceType")
        val deviceTypes = dao.getAll()
        for (deviceType in deviceTypes) {
            writeMessage("> $deviceType")
        }
    }
    private fun testUpdateDeviceType() {
        writeMessage("Update DeviceType")
        val newDeviceType2 = DeviceTypeEntity(
            deviceType2.id,
            deviceType2.typeName + "_new",
        )
        dao.update(newDeviceType2)
    }
    private fun testDeleteDeviceType() {
        writeMessage("Delete DeviceType")
        dao.delete(deviceType1)
    }
}