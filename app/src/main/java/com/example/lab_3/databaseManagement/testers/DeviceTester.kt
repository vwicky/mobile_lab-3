package com.example.lab_3.databaseManagement.testers

import android.util.Log
import com.example.lab_3.databaseManagement.dao.DeviceDAO
import com.example.lab_3.databaseManagement.entities.DeviceEntity

class DeviceTester(private val dao: DeviceDAO) {
    private val device1 = DeviceEntity(1, "Speaker", "Bluetooth speaker", "1.0.0", 0, 1)
    private val device2 = DeviceEntity(2, "Watch", "Fitness smart-watch", "2.1.3", 1, 2)

    private fun writeMessage(message: String) {
        Log.d("TEST", message)
    }
    fun testDB() {
        testInsertDevices()
        testReadDevices()
        testUpdateDevice()
        testDeleteDevice()
        testInsertDevices()
    }
    private fun testInsertDevices() {
        writeMessage("Insert Devices")
        dao.insertDevice(device1)
        dao.insertDevice(device2)
    }
    private fun testReadDevices() {
        writeMessage("Read Devices")
        val devices = dao.getAll()
        for (device in devices) {
            writeMessage("> $device")
        }
    }
    private fun testUpdateDevice() {
        writeMessage("Update Device")
        val updatedDevice2 = device2.copy(name = device2.name + "_updated")
        dao.updateDevice(updatedDevice2)
    }
    private fun testDeleteDevice() {
        writeMessage("Delete Device")
        dao.deleteDevice(device1)
    }
}