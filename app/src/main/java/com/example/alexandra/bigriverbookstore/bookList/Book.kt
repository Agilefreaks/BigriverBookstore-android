package com.example.alexandra.bigriverbookstore.bookList

import com.example.alexandra.bigriverbookstore.resources.BookResource

data class Book(val title: String, val author: String, val picturePath: String?) {
    companion object {
        fun from(bookEntity: BookResource): Book =
            Book(
                title = bookEntity.title,
                author = bookEntity.author.name,
                picturePath = bookEntity.allPhotos.firstOrNull()?.uri
            )
    }
}