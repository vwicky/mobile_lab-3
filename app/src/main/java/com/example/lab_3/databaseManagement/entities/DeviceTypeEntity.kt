package com.example.lab_3.databaseManagement.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device_types")
data class DeviceTypeEntity (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "type_name") val typeName: String,
)
