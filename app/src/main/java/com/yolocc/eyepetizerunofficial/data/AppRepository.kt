package com.yolocc.eyepetizerunofficial.data

import com.yolocc.eyepetizerunofficial.data.body.Category


class AppRepository(private val locatAppDataSource: AppDataSource
                    , private val remoteAppDataSource: AppDataSource): AppDataSource {

    override fun getCategory(): List<Category> = remoteAppDataSource.getCategory()
}