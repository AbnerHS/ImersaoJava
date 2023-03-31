package com.stickers.models.movie;

import java.text.ParseException;

import com.stickers.models.Model;
import com.stickers.utils.ConsoleColors;


public class Movie extends Model {

    private final Double vote_average;
    private final String POSTER_HOST = "https://image.tmdb.org/t/p/w300";

    public Movie(String title, String release_date, Double vote_average, String imageUrl) {
        super(title, imageUrl, release_date);
        this.vote_average = vote_average;
    }    

    public Double getVote_average() {
        return this.vote_average;
    }
    
    public String getPoster_path() {
        return this.POSTER_HOST + this.getImageUrl();
    }

    public void showMovie(Movie movie){
        String ratingStars = "⭐".repeat((int) Math.round(movie.getVote_average()));
        System.out.println(
            ConsoleColors.formatConsole("Título:     ", ConsoleColors.WHITE_BOLD) + 
            ConsoleColors.formatConsole(movie.getTitle(), ConsoleColors.GREEN_UNDERLINED)
            );
        try {
            System.out.println(
                ConsoleColors.formatConsole("Lançamento: ", ConsoleColors.WHITE_BOLD) + 
                ConsoleColors.formatConsole(movie.getDate(), ConsoleColors.GREEN_UNDERLINED)
                );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(
            ConsoleColors.formatConsole("Avaliação:  ", ConsoleColors.WHITE_BOLD) +
            "%s (%s)".formatted(ratingStars, movie.getVote_average())
        );
        System.out.println(
            ConsoleColors.formatConsole("Poster:     ", ConsoleColors.WHITE_BOLD) + 
            ConsoleColors.formatConsole(movie.getPoster_path(), ConsoleColors.GREEN_UNDERLINED)
            );
        System.out.println("-".repeat(75));
    }    
}
