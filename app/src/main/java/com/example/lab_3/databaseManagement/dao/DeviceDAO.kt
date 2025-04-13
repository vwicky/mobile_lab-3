package com.example.lab_3.databaseManagement.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.lab_3.databaseManagement.entities.DeviceEntity

@Dao
interface DeviceDAO {
    @Query("SELECT * FROM devices")
    fun getAll(): List<DeviceEntity>
    @Query("SELECT * FROM devices WHERE is_connected = 1")
    fun getConnectedDevices(): List<DeviceEntity>
    @Query("SELECT * FROM devices WHERE device_type_id = :typeId")
    fun getDevicesByType(typeId: Int): List<DeviceEntity>
    @Query("SELECT * FROM devices WHERE id = :deviceId")
    fun getDeviceById(deviceId: Int): DeviceEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDevice(device: DeviceEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(devices: List<DeviceEntity>)
    @Update
    fun updateDevice(device: DeviceEntity)
    @Delete
    fun deleteDevice(device: DeviceEntity)
    @Query("DELETE FROM devices")
    fun deleteAll()
}
