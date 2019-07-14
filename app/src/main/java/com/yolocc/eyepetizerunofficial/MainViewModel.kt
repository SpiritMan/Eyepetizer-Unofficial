package com.yolocc.eyepetizerunofficial

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.yolocc.eyepetizerunofficial.data.AppRepository
import kotlin.concurrent.thread

class MainViewModel(private val appRepository: AppRepository): ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    /**
     * 获取分类信息
     */
    fun getCategory() {
        thread {
            val categories = appRepository.getCategory()
            Log.d(TAG, "categories size: ${categories.size}")
        }
    }
}