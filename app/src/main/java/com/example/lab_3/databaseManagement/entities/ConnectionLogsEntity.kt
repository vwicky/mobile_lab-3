package com.example.lab_3.databaseManagement.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "connection_logs",
    foreignKeys = [
        ForeignKey(
            entity = DeviceEntity::class,
            parentColumns = ["id"],
            childColumns = ["device_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class ConnectionLogsEntity (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "device_id") val deviceId: Int,
    @ColumnInfo(name = "connected_at") val connectedAt: String,
)