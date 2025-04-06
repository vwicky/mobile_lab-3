package com.example.lab_3

data class DeviceInfo(
    val name: String,
    val description: String,
    val version: String,
    val isDefault: Boolean = false
)