package com.agilefreaks.bigriverbookstore.model;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "series")
public class Series extends Resource {
    public String title;
}
