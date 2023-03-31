package com.stickers.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.annotations.SerializedName;

public class Model {
    private final String title;

    @SerializedName(value = "poster_path", alternate={"url"})
    private final String imageUrl;

    @SerializedName(value = "release_date", alternate={"date"})
    private final String date;

    public Model(String title, String imageUrl, String date) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() throws ParseException{
        SimpleDateFormat dateOriginal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dateOriginal.parse(date));
    }    
}
