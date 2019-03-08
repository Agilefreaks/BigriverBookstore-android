package com.agilefreaks.bigriverbookstore.bookslist

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.agilefreaks.bigriverbookstore.viewmodel.Book
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.ViewTarget
import com.nhaarman.mockitokotlin2.*
import kotlinx.android.synthetic.main.item_list_content.view.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class BookRecyclerViewAdapterTest {

    private val book = Book("1", "Harap Alb", "Creanga", null)

    @Test
    fun getItemCount() {
        val glideMock = mock<RequestManager>()
        val adapter = BookRecyclerViewAdapter(listOf(book), glideMock)
        assertThat(adapter.itemCount, equalTo(1))
        verifyNoMoreInteractions(glideMock)
    }

    @Test
    fun `onBindViewHolder should set book name and author to view`() {
        val textViewMock = mock<TextView>()
        val imageViewMock = mock<ImageView> {  }
        val glideMock = mock<RequestManager>()

        val view = mock<View> {
            on { name } doReturn textViewMock
            on { author } doReturn textViewMock
            on { cover } doReturn imageViewMock
        }

        val viewHolder = BookItemViewHolder(view)
        val adapter = BookRecyclerViewAdapter(listOf(book), glideMock)
        adapter.onBindViewHolder(viewHolder, 0)

        verify(textViewMock, times(1)).text = "Harap Alb"
        verify(textViewMock, times(1)).text = "Creanga"
    }

    @Test
    fun `onBindViewHolder should not load image if there is no link`() {
        val textViewMock = mock<TextView>()
        val imageViewMock = mock<ImageView> {  }
        val glideMock = mock<RequestManager>()

        val view = mock<View> {
            on { name } doReturn textViewMock
            on { author } doReturn textViewMock
            on { cover } doReturn imageViewMock
        }

        val viewHolder = BookItemViewHolder(view)
        val adapter = BookRecyclerViewAdapter(listOf(book), glideMock)
        adapter.onBindViewHolder(viewHolder, 0)

        verify(imageViewMock, times(1)).setImageDrawable(null)
        verify(glideMock, never()).load(any<String>())
    }

    @Test
    fun `onBindViewHolder should load image if a cover is present`() {
        val book = Book("", "", "", "asta maram e link")

        val textViewMock = mock<TextView> { }
        val imageViewMock = mock<ImageView> {  }

        val viewTarget = mock<ViewTarget<ImageView, Drawable>> {  }
        val requestBuilderMock = mock<RequestBuilder<Drawable>> {
            on { into(imageViewMock) } doReturn viewTarget
        }
        val glideMock = mock<RequestManager> {
            on { load(any<String>()) } doReturn requestBuilderMock
        }

        val view = mock<View> {
            on { name } doReturn textViewMock
            on { author } doReturn textViewMock
            on { cover } doReturn imageViewMock
        }

        val viewHolder = BookItemViewHolder(view)
        val adapter = BookRecyclerViewAdapter(listOf(book), glideMock)
        adapter.onBindViewHolder(viewHolder, 0)

        verify(imageViewMock, never()).setImageDrawable(null)
        verify(glideMock, times(1)).load("asta maram e link")
        verify(requestBuilderMock, times(1)).into(imageViewMock)
    }
}