package com.stickers.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.stickers.http.ClientHttp;
import com.stickers.models.nasa.Nasa;



public class NasaService implements Service {

    @Override
    public List<?> fetchContent(String url) {
        ClientHttp http = new ClientHttp();
        String json = http.fetchUrl(url);
        JsonArray postsArray = parseContent(json);
        List<Nasa> postsList = new ArrayList<>();
        for(JsonElement postElement : postsArray){
            Gson gson = new Gson();
            Nasa post = gson.fromJson(postElement, Nasa.class);
            postsList.add(post);
        }
        return postsList;        
    }

    @Override
    public JsonArray parseContent(String json) {
        JsonArray postsArray = JsonParser.parseString(json).getAsJsonArray();
        return postsArray;
    }
}
