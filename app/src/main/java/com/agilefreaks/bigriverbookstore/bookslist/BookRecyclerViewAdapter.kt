package com.agilefreaks.bigriverbookstore.bookslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.databinding.ItemListContentBinding
import com.agilefreaks.bigriverbookstore.viewmodel.Book

class BookRecyclerViewAdapter(
    private val values: List<Book>
) :
    RecyclerView.Adapter<BookItemViewHolder>() {

    private val onBookClickHandler = OnBookClickHandler()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListContentBinding.inflate(inflater)
        return BookItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) = holder.bind(values[position], onBookClickHandler)
    override fun getItemCount() = values.size
}
