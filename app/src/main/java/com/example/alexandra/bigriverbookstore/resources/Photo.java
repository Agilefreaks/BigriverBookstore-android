package com.example.alexandra.bigriverbookstore.resources;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "photos")
public class Photo extends Resource {
    public String title;
    public String uri;
}
