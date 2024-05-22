package com.example.networkingad

data class Book(
    var title: String,
    var subtitle: String? = null,
    var authors: List<String>,
    val url:String)
