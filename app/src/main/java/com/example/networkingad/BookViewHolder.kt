package com.example.networkingad

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingad.databinding.ListItemBinding

class BookViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    private lateinit var currentBook:Book
init{
    binding.root.setOnClickListener{view->
        val bookUri= Uri.parse(currentBook.url)
        val websiteIntent = Intent(Intent.ACTION_VIEW,bookUri)
        itemView.context.startActivity(websiteIntent)
    }
}

    fun bindBook(book:Book){
        currentBook = book
        val authors = book.authors.joinToString()
        val title = book.title
        val subtitle=book.subtitle
        binding.authorTextView.text=authors.toString()
        binding.bookSubtitleTextView.text=subtitle
        binding.bookTitleTextView.text=title
    }
}