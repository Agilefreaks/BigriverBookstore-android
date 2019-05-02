package com.example.alexandra.bigriverbookstore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.book_list)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val users = ArrayList<Book>()
        users.add(Book("Paul", "book t1", "C:\\AlexandraFiles\\Projects\\BigriverBookstore\\app\\src\\main\\res\\drawable\\book1.jpg"))
        users.add(Book("Jane", "book t2","C:\\AlexandraFiles\\Projects\\BigriverBookstore\\app\\src\\main\\res\\drawable\\book2.jpg"))
        users.add(Book("John", "book t3","C:\\AlexandraFiles\\Projects\\BigriverBookstore\\app\\src\\main\\res\\drawable\\book1.jpg"))
        users.add(Book("Amy", "book t4","C:\\AlexandraFiles\\Projects\\BigriverBookstore\\app\\src\\main\\res\\drawable\\book2.jpg"))

        var adapter = BookAdapter(users)
        rv.adapter = adapter
    }
}
