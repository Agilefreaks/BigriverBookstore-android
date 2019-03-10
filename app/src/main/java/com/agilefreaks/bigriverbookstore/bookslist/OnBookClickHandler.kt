package com.agilefreaks.bigriverbookstore.bookslist

import android.content.Intent
import android.view.View
import com.agilefreaks.bigriverbookstore.BookDetailActivity
import com.agilefreaks.bigriverbookstore.BookDetailFragment
import com.agilefreaks.bigriverbookstore.viewmodel.Book

class OnBookClickHandler {
    fun onBookClick(view: View) {
        val item = view.tag as Book
        val intent = Intent(
            view.context, BookDetailActivity::class.java
        ).apply {
            putExtra(BookDetailFragment.ARG_BOOK_ID, item.id)
        }
        view.context.startActivity(intent)
    }
}
