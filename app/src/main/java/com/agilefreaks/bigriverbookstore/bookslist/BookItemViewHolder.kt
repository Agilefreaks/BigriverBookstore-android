package com.agilefreaks.bigriverbookstore.bookslist

import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.databinding.ItemListContentBinding
import com.agilefreaks.bigriverbookstore.viewmodel.Book

class BookItemViewHolder(private val binding: ItemListContentBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(book: Book, handler: OnBookClickHandler) {
        binding.book = book
        binding.handler = handler
        binding.executePendingBindings()
    }
}
