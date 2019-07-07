package com.yolocc.eyepetizerunofficial

import android.arch.lifecycle.ViewModel
import com.yolocc.eyepetizerunofficial.data.AppRepository
import kotlin.concurrent.thread

class MainViewModel(private val appRepository: AppRepository): ViewModel() {

    /**
     * 获取分类信息
     */
    fun getCategory() {
        thread {
            appRepository.getCategory()
        }
    }
}