package com.agilefreaks.bigriverbookstore.bookslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.R
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.data.BooksRepository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import java.util.concurrent.Executors
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
        val glide = Glide.with(this)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = BookRecyclerViewAdapter(emptyList(), glide)

        thread {
            val repository = BooksRepository(Api.newInstance(), Executors.newSingleThreadExecutor())
            val future = repository.getBooks()
            val books = future.get()
            runOnUiThread {
                recyclerView.adapter = BookRecyclerViewAdapter(books, glide)
            }
        }
    }
}
