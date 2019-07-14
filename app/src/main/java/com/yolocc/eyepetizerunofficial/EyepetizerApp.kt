package com.yolocc.eyepetizerunofficial

import android.app.Application

class EyepetizerApp : Application() {

    companion object {
        lateinit var INSTANCE : EyepetizerApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}