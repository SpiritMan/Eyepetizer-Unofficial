package com.yolocc.eyepetizerunofficial.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {

    /**
     * 判断是否连接网络
     */
    fun networkCont(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo as NetworkInfo
        return networkInfo.isConnected
    }


}