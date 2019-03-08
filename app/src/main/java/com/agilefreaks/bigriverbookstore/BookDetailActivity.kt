package com.agilefreaks.bigriverbookstore

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_detail.*

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val fragment = BookDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        BookDetailFragment.ARG_BOOK_ID,
                        intent.getStringExtra(BookDetailFragment.ARG_BOOK_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, BookListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
