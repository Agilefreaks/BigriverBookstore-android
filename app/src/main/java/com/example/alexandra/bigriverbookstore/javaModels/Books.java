package com.example.alexandra.bigriverbookstore.javaModels;

import com.squareup.moshi.Json;
import moe.banana.jsonapi2.JsonApi;

import java.util.List;

@JsonApi(type = "books")
public class Books {
    public String title;
    @Json(name = "date_published")
    public String datePublished;
    public String isbn;
    public String author;
    public List<Photos> photos;
}
