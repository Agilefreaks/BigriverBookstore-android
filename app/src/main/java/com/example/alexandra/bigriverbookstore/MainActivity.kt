package com.example.alexandra.bigriverbookstore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.alexandra.bigriverbookstore.bookList.BookAdapter
import com.example.alexandra.bigriverbookstore.bookList.BooksRepository
import com.example.alexandra.bigriverbookstore.bookList.GetBooksRequest
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
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.adapter = BookAdapter(emptyList())

        thread {
            val repository =
                BooksRepository(GetBooksRequest.newInstance())
            val future = repository.getBooks()
            val books = future.get()
            runOnUiThread {
                recyclerView.adapter = BookAdapter(books)
            }
        }
    }
}

