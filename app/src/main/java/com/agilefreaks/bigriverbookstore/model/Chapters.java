package com.agilefreaks.bigriverbookstore.model;

import moe.banana.jsonapi2.JsonApi;
import moe.banana.jsonapi2.Resource;

@JsonApi(type = "chapters")
public class Chapters extends Resource {
    public String title;
    public Integer ordering;
}
