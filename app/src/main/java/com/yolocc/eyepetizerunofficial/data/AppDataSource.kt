package com.yolocc.eyepetizerunofficial.data

import com.yolocc.eyepetizerunofficial.data.body.Category

interface AppDataSource {

    fun getCategory(): List<Category>
}