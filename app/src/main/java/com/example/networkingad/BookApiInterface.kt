package com.example.networkingad

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


private const val QUERY_STRING=
    "volumes?query?format=geojson&q=Android&maxResults=10"

interface BookApiInterface {
    @GET(QUERY_STRING)
    fun getBooks():Call<GoogleBooksResponse>
}

private const val BASE_URL="https://www.googleapis.com/books/v1/"
//moshi
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofitObject = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi)).build()

object BookApiObject{
    val bookApiObject:BookApiInterface by lazy{
        retrofitObject.create(BookApiInterface::class.java)
    }
}