package com.agilefreaks.bigriverbookstore.bookslist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.BookDetailActivity
import com.agilefreaks.bigriverbookstore.BookDetailFragment
import com.agilefreaks.bigriverbookstore.R
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import com.bumptech.glide.RequestManager

class BookRecyclerViewAdapter(
    private val values: List<Book>,
    private val glide: RequestManager
) :
    RecyclerView.Adapter<BookItemViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { view ->
            val item = view.tag as Book
            val intent = Intent(
                view.context,
                BookDetailActivity::class.java
            ).apply {
                putExtra(BookDetailFragment.ARG_BOOK_ID, item.id)
            }
            view.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return BookItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val book = values[position]
        holder.name.text = book.name
        holder.author.text = book.author
        if (book.cover != null) {
            glide.load(book.cover).into(holder.cover)
        } else {
            holder.cover.setImageDrawable(null)
        }

        with(holder.itemView) {
            tag = book
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

}