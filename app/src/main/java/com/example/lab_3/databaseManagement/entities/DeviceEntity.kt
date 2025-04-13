package com.example.lab_3.databaseManagement.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "devices",
    foreignKeys = [
        ForeignKey(
            entity = DeviceTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["device_type_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DeviceEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "version") val version: String,
    @ColumnInfo(name = "is_connected") val isConnected: Int,
    @ColumnInfo(name = "device_type_id", index = true) val deviceTypeId: Int,
)