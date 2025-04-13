package com.example.lab_3.databaseManagement.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lab_3.databaseManagement.entities.ConnectionLogsEntity

@Dao
interface ConnectionLogsDAO {
    @Query("SELECT * FROM connection_logs")
    fun getAll(): List<ConnectionLogsEntity>
    @Query("SELECT * FROM connection_logs WHERE device_id = :deviceId")
    fun getLogsByDevice(deviceId: Int): List<ConnectionLogsEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(log: ConnectionLogsEntity): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(logs: List<ConnectionLogsEntity>)
    @Delete
    fun delete(log: ConnectionLogsEntity)
    @Query("DELETE FROM connection_logs")
    fun deleteAll()
}
