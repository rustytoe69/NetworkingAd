package com.example.networkingad

import com.squareup.moshi.Json


class GoogleBooksResponse {
    @Json(name="items")
    lateinit var bookItemsList:List<BookItems>
}
class BookItems{
    @Json(name="volumeInfo")
    lateinit var volumeInfo: VolumeInfo
}
class VolumeInfo{
    @Json(name="title")
    var title:String=""
    @Json(name="subtitle")
    var subtitle:String?=""
    @Json(name="authors")
    lateinit var authors:List<String>
    @Json(name="infoLink")
    lateinit var url:String
}
