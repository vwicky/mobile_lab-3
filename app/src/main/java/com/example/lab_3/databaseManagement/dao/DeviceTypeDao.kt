package com.example.lab_3.databaseManagement.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.lab_3.databaseManagement.entities.DeviceTypeEntity

@Dao
interface DeviceTypeDAO {
    @Query("SELECT * FROM device_types")
    fun getAll(): List<DeviceTypeEntity>
    @Query("SELECT * FROM device_types WHERE id = :typeId")
    fun getById(typeId: Int): DeviceTypeEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(deviceType: DeviceTypeEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(deviceTypes: List<DeviceTypeEntity>)
    @Update
    fun update(deviceType: DeviceTypeEntity)
    @Delete
    fun delete(deviceType: DeviceTypeEntity)
    @Query("DELETE FROM device_types")
    fun deleteAll()
}
