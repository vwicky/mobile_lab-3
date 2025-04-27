package com.example.lab_3.mvpLR6.data.repository

import com.example.lab_3.databaseManagement.entities.DeviceEntity
import com.example.lab_3.restfulManagement.Device

class DeviceTranslator {
    companion object {
        fun entityToDevice(entity: DeviceEntity): Device {
            val device = Device()
            device.name = entity.name
            device.description = entity.description
            device.version = entity.version
            return device
        }
        fun deviceToEntity(device: Device): DeviceEntity {
            return DeviceEntity(
                id = 0, // Room will auto-generate id
                name = device.name ?: "",
                description = device.description ?: "",
                version = device.version ?: "",
                isConnected = 0, // Default value, unless you have real connection info
                deviceTypeId = 1 // -- entity doesn't have this implemented
            )
        }
    }
}