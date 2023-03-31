package com.stickers.services;

import java.util.List;

import com.google.gson.JsonArray;

public interface Service {
    List<?> fetchContent(String url);
    JsonArray parseContent(String json);
}
