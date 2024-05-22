package com.example.networkingad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.networkingad.databinding.ListItemBinding

class BookAdapter(val books:List<Book>) : RecyclerView.Adapter<BookViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return BookViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bindBook(book)
    }

    override fun getItemCount(): Int {
        return books.size
    }
}