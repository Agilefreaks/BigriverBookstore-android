package com.agilefreaks.bigriverbookstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agilefreaks.bigriverbookstore.api.Api
import com.agilefreaks.bigriverbookstore.data.BigRiverRepository
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class BookDetailFragment : Fragment() {

    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_BOOK_ID)) {
                val bookId = it.getString(ARG_BOOK_ID)?.toIntOrNull() ?: throw IllegalStateException("bookId must be present.")
                thread {
                    val repository = BigRiverRepository(Api.newInstance(), Executors.newSingleThreadExecutor())
                    val future = repository.getBook(bookId)
                    val book = future.get()
                    activity?.runOnUiThread {
                        activity?.toolbar_layout?.title = book?.name
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        book?.let {
            rootView.item_detail.text = it.name
        }

        return rootView
    }

    companion object {
        const val ARG_BOOK_ID = "item_id"
    }
}
