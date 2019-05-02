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
        val users = ArrayList<User>()
        users.add(User("Paul", "book t1"))
        users.add(User("Jane", "book t2"))
        users.add(User("John", "book t3"))
        users.add(User("Amy", "book t4"))

        var adapter = BookAdapter(users)
        rv.adapter = adapter
    }
}
