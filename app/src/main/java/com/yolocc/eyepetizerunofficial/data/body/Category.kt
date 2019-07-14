package com.yolocc.eyepetizerunofficial.data.body

/**
 * {
"id": 14,
"name": "广告",
"alias": null,
"description": "为广告人的精彩创意点赞",
"bgPicture": "http://img.kaiyanapp.com/57472e13fd2b6c9655c8a600597daf4d.png?imageMogr2/quality/60/format/jpg",
"bgColor": "",
"headerImage": "http://img.kaiyanapp.com/fc228d16638214b9803f46aabb4f75e0.png",
"defaultAuthorId": 2162,
"tagId": 16
}
 */
data class Category(
    val id: Int,
    val name: String,
    val description: String,
    val bgPicture: String,
    val headerImage: String,
    val defaultAuthorId: Int,
    val tagId: Int
)