package com.example.alexandra.bigriverbookstore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alexandra.bigriverbookstore.databinding.BookListItemBinding

class BookAdapter(private val bookList: ArrayList<Book>) : RecyclerView.Adapter<BookHolder>() {

    override fun onBindViewHolder(holder: BookHolder, position: Int) = holder.bind(bookList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BookListItemBinding.inflate(layoutInflater)
        return BookHolder(binding)
    }

    override fun getItemCount(): Int = bookList.size
}
