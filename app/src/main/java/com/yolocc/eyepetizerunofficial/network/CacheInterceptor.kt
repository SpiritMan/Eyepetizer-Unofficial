package com.yolocc.eyepetizerunofficial.network

import android.content.Context
import android.util.Log
import com.yolocc.eyepetizerunofficial.util.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * https://juejin.im/post/5a60c4866fb9a01ca872075f 参考文档
 * 缓存机制
 * 有网络时直接获取网络资源
 * 没有网络时获取缓存资源
 */

class CacheInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val responseBuilder = response.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
        if (NetworkUtils.networkCont(context)) {
            // read from cache for 60 s
            //允许获取60s内的缓存
            val maxAge = 60
            val cacheControl = request.cacheControl.toString()
            Log.e("CacheInterceptor", "6s load cache $cacheControl")
            //"Pragma"表示不适用缓存机制
            responseBuilder.header("Cache-Control", "public, max-age=$maxAge")
        } else {
            Log.e("CacheInterceptor", " no network load cahe")
//            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
            //set cahe times is 3 days
            val maxStale = 60 * 60 * 24 * 3
            //max-stale: 表示接收过期的缓存，如后面未指定参数，则表示永远接收缓存数据。如max-stale: 3600, 表示可接受过期1小时内的数据；
            //only-if-cache: 表示直接获取缓存数据，若没有数据返回，则返回504（Gateway Timeout)
            responseBuilder.header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
        }
        return responseBuilder.build()
    }
}