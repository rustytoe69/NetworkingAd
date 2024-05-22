package com.example.networkingad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel: ViewModel() {
    private val _response = MutableLiveData<List<Book>>()
    val response:LiveData<List<Book>>
        get() = _response
    fun getBooks(){
        val request = BookApiObject.bookApiObject.getBooks()
        request.enqueue(object:Callback<GoogleBooksResponse>{
            override fun onFailure(call: Call<GoogleBooksResponse>, t: Throwable) {
                Log.d("RESPONSE","Failure"+t.message)
            }

            override fun onResponse(call: Call<GoogleBooksResponse>, response: Response<GoogleBooksResponse>) {
                var listOfBooksFetched = mutableListOf<Book>()

                val googleBooksResponse:GoogleBooksResponse?=response.body()
                val bookItemsList = googleBooksResponse?.bookItemsList?:listOf()

                for(bookItems in bookItemsList){
                    val volumeInfo = bookItems.volumeInfo

                    val authors = volumeInfo.authors
                    val title = volumeInfo.title
                    val subtitle = volumeInfo.subtitle
                    val url = volumeInfo.url

                    val newBook = Book(title,subtitle,authors,url)
                    listOfBooksFetched.add(newBook)
                }
                _response.value = listOfBooksFetched
            }
        })
    }
}