package com.yolocc.eyepetizerunofficial.data


class AppRepository(val locatAppDataSource: AppDataSource
                    , val remoteAppDataSource: AppDataSource): AppDataSource {

    override fun getCategory() {
        remoteAppDataSource.getCategory()
    }
}