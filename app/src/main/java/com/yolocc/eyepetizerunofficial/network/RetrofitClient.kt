package com.yolocc.eyepetizerunofficial.network

import android.app.Application
import android.util.Log
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor(application: Application) {

    private var retrofit: Retrofit
    private val DEFAULT_TIMEOUT = 20L

    init {
        //缓存地址
        val httpCacheDirectory = File(application.cacheDir, "app_cache")
        var cache: Cache? = null
        try {
            cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
        } catch (e: Exception) {
            Log.e("OKHttp", "Could not create http cache", e)
        }
        //okhttp创建了
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .cache(cache)
            .addInterceptor(CacheInterceptor(application))
            .addNetworkInterceptor(CacheInterceptor(application))
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
        //retrofit创建了
        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://baobab.kaiyanapp.com/api/")
            .build()
    }

    fun <T> create(service: Class<T>) : T = retrofit.create(service)


    companion object {

        @Volatile
        private var INSTANCE: RetrofitClient? = null

        fun getInstance(application: Application): RetrofitClient =
            INSTANCE ?: synchronized(RetrofitClient::class.java) {
                INSTANCE ?: RetrofitClient(application).also { INSTANCE = it }
            }
    }
}