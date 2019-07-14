package com.yolocc.eyepetizerunofficial.data.remote

import com.yolocc.eyepetizerunofficial.EyepetizerApp
import com.yolocc.eyepetizerunofficial.data.AppDataSource
import com.yolocc.eyepetizerunofficial.data.body.Category
import com.yolocc.eyepetizerunofficial.network.ApiService
import com.yolocc.eyepetizerunofficial.network.RetrofitClient

class RemoteAppDataSource: AppDataSource {

    private val retrofitClient = RetrofitClient.getInstance(EyepetizerApp.INSTANCE)

    override fun getCategory(): List<Category> {
        return retrofitClient.create(ApiService::class.java).getCategory().execute().body() ?: listOf()
    }
}