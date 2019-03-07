package com.agilefreaks.bigriverbookstore.viewmodel

import com.agilefreaks.bigriverbookstore.model.Books

data class Book(val id: String, val name: String, val author: String, val cover: String?) {
    companion object {
        fun from(book: Books): Book {
            val id = book.id
            val title = book.title
            val author = book.author.name
            val cover = book.photos.firstOrNull()?.uri
            return Book(id, title, author, cover)
        }
    }
}