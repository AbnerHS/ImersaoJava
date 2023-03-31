package com.stickers;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.stickers.models.movie.Movie;
import com.stickers.models.nasa.Nasa;
import com.stickers.services.MovieService;
import com.stickers.services.NasaService;
import com.stickers.stickers.StickerGenerator;
import com.stickers.utils.Property;

public class App {

    public static void main(String[] args) {
        try {
            App app = new App();
            app.runMovieApi();
            app.runNasaApi();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void runMovieApi() throws Exception {
        String urlMovieApi = String.format("%s&api_key=%s", 
            Property.getProperty("movie.api.url"), 
            Property.getProperty("movie.api.key")
        );
        MovieService movieService = new MovieService();
        @SuppressWarnings(value = "unchecked")
        List<Movie> movieList = (List<Movie>) movieService.fetchContent(urlMovieApi);
        for(Movie movie : movieList){
            movie.showMovie(movie);
            InputStream inputStream = new URL(movie.getPoster_path()).openStream();
            String fileName = "img/movie/" + movie.getTitle().replace(":", " -") + ".png";

            StickerGenerator stickerGenerator = new StickerGenerator();
            String legend = movie.getVote_average() > 7 ? "Top demais" : "Mais ou Menos";
            stickerGenerator.createSticker(inputStream, fileName, legend);                
        }
    }

    public void runNasaApi() throws Exception {
        String startDate = "2022-06-01";
        String endDate = "2022-06-30";
        String urlNasaApi = String.format("%s?api_key=%s&start_date=%s&end_date=%s", 
                Property.getProperty("nasa.api.url"), 
                Property.getProperty("nasa.api.key"),
                startDate,
                endDate
            );
        NasaService nasaService = new NasaService();
        @SuppressWarnings(value = "unchecked")
        List<Nasa> nasaList = (List<Nasa>) nasaService.fetchContent(urlNasaApi);
        for(Nasa nasa : nasaList){
            nasa.showNasaPost(nasa);

            InputStream inputStream = new URL(nasa.getImageUrl()).openStream();
            String fileName = "img/nasa/" + nasa.getTitle().replace(":", " -") + ".png";

            StickerGenerator stickerGenerator = new StickerGenerator();
            String legend = nasa.getTitle();
            stickerGenerator.createSticker(inputStream, fileName, legend);
        }
    }
}
