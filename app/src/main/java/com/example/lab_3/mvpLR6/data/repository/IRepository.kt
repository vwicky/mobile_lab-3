package com.example.lab_3.mvpLR6.data.repository

import androidx.room.Dao
import com.example.lab_3.databaseManagement.entities.DeviceEntity
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.restfulManagement.Device

@Deprecated(
    message = "Чучуть провтикав, створив окремий клас",
    replaceWith = ReplaceWith("MainContract.Repository")
)
interface IRepository {
    suspend fun getData(callback: IDataSource.DevicesCallback)
}
