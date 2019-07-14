package com.yolocc.eyepetizerunofficial.network

import com.yolocc.eyepetizerunofficial.data.body.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    companion object {
        private const val UID = "26868b32e808498db32fd51fb422d00175e179df"
        private const val VC = 83
    }

    //获取分类信息
    @GET("v2/categories?udid=$UID&vc=$VC")
    fun getCategory(): Call<List<Category>>
}