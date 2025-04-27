package com.example.lab_3.databaseManagement

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.lab_3.DeviceAdapter
import com.example.lab_3.DeviceInfo
import com.example.lab_3.ILab

class Lab4(
    val applicationContext: Context,
    val recyclerView: RecyclerView,
) : ILab {
    var deviceInfos: List<DeviceInfo>? = null

    fun getDeviceInfosSafe() : List<DeviceInfo> {
        if (deviceInfos == null) {
            this.test()
        }
        return deviceInfos!!
    }

    override fun test() {
        val db = Room.databaseBuilder(
            applicationContext,
            GeneralDatabase::class.java, "general-database"
        ).allowMainThreadQueries().build()
        // dbTester = DatabaseTester(db)
        val deviceDao = db.devicesDao()
        val devicesFromDb = deviceDao.getAll()

        deviceInfos = devicesFromDb.map {
            DeviceInfo(it.name, it.description, it.version)
        }
    }
}