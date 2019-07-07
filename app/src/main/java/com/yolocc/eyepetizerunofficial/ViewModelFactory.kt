package com.yolocc.eyepetizerunofficial

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.yolocc.eyepetizerunofficial.data.AppRepository
import com.yolocc.eyepetizerunofficial.data.local.LocatAppDataSource
import com.yolocc.eyepetizerunofficial.data.remote.RemoteAppDataSource

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(
    private val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel(appRepository)
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        } as T
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(AppRepository(LocatAppDataSource(), RemoteAppDataSource()))
                    .also { INSTANCE = it }
            }
    }

}