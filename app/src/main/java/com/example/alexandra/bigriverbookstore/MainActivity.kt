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
        users.add(
            Book(
                "Paul k",
                "book t1",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        users.add(
            Book(
                "Jane p",
                "book t2",
                "https://lorempixel.com//400//300//abstract//Faker//?50139"
            )
        )
        users.add(
            Book(
                "John d",
                "book t3",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        users.add(
            Book(
                "Amy f",
                "book t4",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        users.add(
            Book(
                "Amy f",
                "book t5",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        users.add(
            Book(
                "Amy f",
                "book t6",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        rv.adapter = BookAdapter(users)
    }
}
