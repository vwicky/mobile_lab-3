package com.example.lab_3.databaseManagement

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab_3.databaseManagement.dao.ConnectionLogsDAO
import com.example.lab_3.databaseManagement.dao.DeviceDAO
import com.example.lab_3.databaseManagement.dao.DeviceTypeDAO
import com.example.lab_3.databaseManagement.entities.ConnectionLogsEntity
import com.example.lab_3.databaseManagement.entities.DeviceEntity
import com.example.lab_3.databaseManagement.entities.DeviceTypeEntity

@Database(
    entities = [
        DeviceEntity::class,
        DeviceTypeEntity::class,
        ConnectionLogsEntity::class],
    version = 1,)
abstract class GeneralDatabase : RoomDatabase() {
    abstract fun devicesDao(): DeviceDAO
    abstract fun devicesTypeDao(): DeviceTypeDAO
    abstract fun connectionLogsDao(): ConnectionLogsDAO
}