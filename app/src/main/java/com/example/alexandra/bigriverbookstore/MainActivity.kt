package com.example.alexandra.bigriverbookstore

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.alexandra.bigriverbookstore.databinding.BookListItemBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: BookListItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val bookModel = Book("Author name", "Book title", "https://lorempixel.com//400//300//abstract//Faker//?50138")
        binding.setVariable(BR.bookModel, bookModel)
        binding.setLifecycleOwner(this)
        binding.executePendingBindings()

        val rv = findViewById<RecyclerView>(R.id.book_list)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val books = ArrayList<Book>()
        books.add(
            Book(
                "Paul k",
                "book t1",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        books.add(
            Book(
                "Jane p",
                "book t2",
                "https://lorempixel.com//400//300//abstract//Faker//?50139"
            )
        )
        books.add(
            Book(
                "John d",
                "book t3",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        books.add(
            Book(
                "Amy f",
                "book t4",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        books.add(
            Book(
                "Amy f",
                "book t5",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        books.add(
            Book(
                "Amy f",
                "book t6",
                "https://lorempixel.com//400//300//abstract//Faker//?50138"
            )
        )
        rv.adapter = BookAdapter(books)
    }
}
