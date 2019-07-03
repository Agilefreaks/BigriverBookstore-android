package com.example.alexandra.bigriverbookstore

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("android:src")
fun ImageView.bindSrc(imageUrl: String){
    Picasso.get().load(imageUrl).into(this)
}
