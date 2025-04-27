package com.example.lab_3.mvpLR6.di

import android.content.Context
import androidx.room.Room
import com.example.lab_3.databaseManagement.GeneralDatabase
import com.example.lab_3.mvpLR6.data.IDataSource
import com.example.lab_3.mvpLR6.data.TestAPIService
import com.example.lab_3.mvpLR6.data.api.RetrofitAPIHelper
import com.example.lab_3.mvpLR6.data.repository.Repository
import com.example.lab_3.mvpLR6.ui.MainContract
import com.example.lab_3.mvpLR6.ui.MainPresenter

class DiHelper {
    companion object {
        private var mainPresenter: MainContract.Presenter? = null
        private var service: IDataSource? = null

        private var repository: MainContract.Repository? = null
        private var db: GeneralDatabase? = null
        // private var retrofitHelper: RetrofitAPIHelper.Companion? = null

        fun getPresenter(view: MainContract.View) : MainContract.Presenter {
            if (mainPresenter == null) {
                mainPresenter = MainPresenter(view)
            }
            return mainPresenter!!
        }
        fun getService() : IDataSource {
            if (service == null) {
                service = TestAPIService()
            }
            return service!!
        }
        fun getRetrofitHelper() : RetrofitAPIHelper.Companion {
            RetrofitAPIHelper.init()
            return RetrofitAPIHelper
        }

        fun getDatabase(applicationContext: Context) : GeneralDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    applicationContext,
                    GeneralDatabase::class.java, "general-database"
                ).allowMainThreadQueries().build()
            }
            return db!!
        }
        fun getRepository(applicationContext: Context) : MainContract.Repository {
            if (repository == null) {
                repository = Repository(
                    this.getService(),
                    this.getDatabase(applicationContext)
                )
            }
            return repository!!
        }
    }
}