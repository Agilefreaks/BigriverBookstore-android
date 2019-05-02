package com.example.alexandra.bigriverbookstore

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BookAdapter(val userList: ArrayList<User>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName?.text = userList[position].name
        holder.txtTitle?.text = userList[position].title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
    }
}
