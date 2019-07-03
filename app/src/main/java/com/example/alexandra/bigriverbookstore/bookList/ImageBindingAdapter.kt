package com.example.alexandra.bigriverbookstore.bookList

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.alexandra.bigriverbookstore.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:src")
fun ImageView.bindSrc(imageUrl: String?) {
    Picasso
        .get()
        .load(imageUrl)
        .placeholder(R.drawable.default_image)
        .into(this)
}
