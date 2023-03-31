package com.stickers.models.nasa;

import java.text.ParseException;

import com.stickers.models.Model;
import com.stickers.utils.ConsoleColors;

public class Nasa extends Model {

    private final String copyright;    

    public Nasa(String title, String imageUrl, String copyright, String date) {
        super(title, imageUrl, date);
        this.copyright = copyright;
    }

    public String getCopyright() {
        return copyright;
    }

    public void showNasaPost(Nasa nasa){
        System.out.println(
            ConsoleColors.formatConsole("Título:    ", ConsoleColors.WHITE_BOLD) + 
            ConsoleColors.formatConsole(nasa.getTitle(), ConsoleColors.GREEN_UNDERLINED)
            );
        try {
            System.out.println(
                ConsoleColors.formatConsole("Data       ", ConsoleColors.WHITE_BOLD) + 
                ConsoleColors.formatConsole(nasa.getDate(), ConsoleColors.GREEN_UNDERLINED)
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(
            ConsoleColors.formatConsole("Copyright  ", ConsoleColors.WHITE_BOLD) + 
            ConsoleColors.formatConsole(nasa.getCopyright(), ConsoleColors.GREEN_UNDERLINED)
            );
        System.out.println(
            ConsoleColors.formatConsole("Imagem:    ", ConsoleColors.WHITE_BOLD) + 
            ConsoleColors.formatConsole(nasa.getImageUrl(), ConsoleColors.GREEN_UNDERLINED)
        );
        System.out.println("-".repeat(80));
    }
}
