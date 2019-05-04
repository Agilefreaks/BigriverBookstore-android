package com.example.alexandra.bigriverbookstore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.book_list)
        setRecycleView(recycleView)
    }

    private fun setRecycleView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)

//        val books = ArrayList<Book>()
//        books.add(
//            Book(
//                "Paul k",
//                "book t1",
//                "https://lorempixel.com//400//300//abstract//Faker//?50138"
//            )
//        )
//        books.add(
//            Book(
//                "Jane p",
//                "book t2",
//                "https://lorempixel.com//400//300//abstract//Faker//?50139"
//            )
//        )
//        books.add(
//            Book(
//                "John d",
//                "book t3",
//                "https://lorempixel.com//400//300//abstract//Faker//?50138"
//            )
//        )
//        books.add(
//            Book(
//                "Amy f",
//                "book t4",
//                "https://lorempixel.com//400//300//abstract//Faker//?50138"
//            )
//        )
//        books.add(
//            Book(
//                "Amy f",
//                "book t5",
//                "https://lorempixel.com//400//300//abstract//Faker//?50138"
//            )
//        )
//        books.add(
//            Book(
//                "Amy f",
//                "book t6",
//                "https://lorempixel.com//400//300//abstract//Faker//?50138"
//            )
//        )
        //  recyclerView.adapter = BookAdapter(books)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.adapter = BookAdapter()

        thread {
            val repository = BooksRepository(ApiRequests.newInstance())
            val future = repository.getBooks()
            val books = future.get()
            runOnUiThread {
                recyclerView.adapter = BookAdapter(books)
            }
        }
    }
}

