package com.agilefreaks.bigriverbookstore.bookslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.R
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.data.BooksRepository
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlin.concurrent.thread

class BookListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        setupRecyclerView(item_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = BookRecyclerViewAdapter(emptyList())

        thread {
            val repository = BooksRepository(Api.newInstance())
            val future = repository.getBooks()
            val books = future.get()
            runOnUiThread {
                recyclerView.adapter = BookRecyclerViewAdapter(books)
            }
        }
    }
}
