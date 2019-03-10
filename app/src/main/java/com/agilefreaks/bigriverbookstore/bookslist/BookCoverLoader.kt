package com.agilefreaks.bigriverbookstore.bookslist

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun loadUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context).load(url).into(view)
    } else {
        view.setImageDrawable(null)
    }
}
