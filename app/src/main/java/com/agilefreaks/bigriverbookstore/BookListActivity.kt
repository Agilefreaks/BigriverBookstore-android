package com.agilefreaks.bigriverbookstore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.data.BooksRepository
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list_content.view.*
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
        val repository = BooksRepository(Api.newInstance(), Executors.newSingleThreadExecutor())
        val future = repository.getBooks()

        thread {
            val books = future.get()
            runOnUiThread {
                recyclerView.adapter = SimpleItemRecyclerViewAdapter(books)
            }
        }
    }

    class SimpleItemRecyclerViewAdapter(
        private val values: List<Book>
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { view ->
                val book = view.tag as Book

                val intent = Intent(view.context, BookDetailActivity::class.java).apply {
                    putExtra(BookDetailFragment.ARG_BOOK_ID, book.id)
                }
                view.context.startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val book = values[position]
            holder.idView.text = book.name
            holder.contentView.text = book.author

            with(holder.itemView) {
                tag = book
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }
}
