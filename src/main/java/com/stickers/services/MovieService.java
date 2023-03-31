package com.stickers.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stickers.http.ClientHttp;
import com.stickers.models.movie.Movie;


public class MovieService implements Service {
    
    @Override
    public List<?> fetchContent(String url) {
        ClientHttp http = new ClientHttp();
        String json = http.fetchUrl(url);
        JsonArray moviesArray = parseContent(json);
        List<Movie> moviesList = new ArrayList<>();
        for(JsonElement movieElement : moviesArray){
            Gson gson = new Gson();
            Movie movie = gson.fromJson(movieElement, Movie.class);
            moviesList.add(movie);
        }
        return moviesList;
    }

    @Override
    public JsonArray parseContent(String json) {
        JsonObject bodyJson = JsonParser.parseString(json).getAsJsonObject();
        JsonArray moviesArray = bodyJson.getAsJsonArray("results");
        return moviesArray;
    }
}
