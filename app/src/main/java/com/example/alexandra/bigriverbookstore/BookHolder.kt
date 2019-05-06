package com.example.alexandra.bigriverbookstore

import android.support.v7.widget.RecyclerView
import com.example.alexandra.bigriverbookstore.databinding.BookListItemBinding

class BookHolder(private val binding: BookListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(book: Book) {
        binding.bookModel = book
        binding.executePendingBindings()
    }
}