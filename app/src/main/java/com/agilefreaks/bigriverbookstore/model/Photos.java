package com.agilefreaks.bigriverbookstore.model;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "photos")
public class Photos extends Resource {
    public String title;
    public String uri;
}
