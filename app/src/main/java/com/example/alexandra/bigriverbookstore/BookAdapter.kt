package com.example.alexandra.bigriverbookstore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class BookAdapter(private val bookList: ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.authorName.text = bookList[position].authorName
        holder.bookTitle.text = bookList[position].bookTitle
        val imageUrl = bookList[position].picturePath
        holder.updateWithUrl(imageUrl)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = bookList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorName: TextView by lazy { itemView.findViewById<TextView>(R.id.authorName) }
        val bookTitle: TextView by lazy { itemView.findViewById<TextView>(R.id.bookTitle) }
        val bookImage: ImageView by lazy {
            itemView.findViewById<ImageView>(R.id.bookImage)
        }

        fun updateWithUrl(url: String) {
            Picasso.get().load(url).into(bookImage)
        }
    }
}
