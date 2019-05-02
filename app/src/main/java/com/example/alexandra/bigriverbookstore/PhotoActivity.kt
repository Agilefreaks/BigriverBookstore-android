package com.example.alexandra.bigriverbookstore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso

class PhotoActivity : AppCompatActivity() {

    private var selectedPhoto: Photo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_photo)

        selectedPhoto = intent.getSerializableExtra(PHOTO_KEY) as Photo
        Picasso.with(this).load(selectedPhoto?.url).into(photoImageView)

        photoDescription?.text = selectedPhoto?.explanation
    }

    companion object {
        private val PHOTO_KEY = "PHOTO"
    }
}
