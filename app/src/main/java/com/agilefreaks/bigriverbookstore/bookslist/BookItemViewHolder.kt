package com.agilefreaks.bigriverbookstore.bookslist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_content.view.*

class BookItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.name
    val author: TextView = view.author
    val cover: ImageView = view.cover
}