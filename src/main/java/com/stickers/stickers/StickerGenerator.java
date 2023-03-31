package com.stickers.stickers;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {

    public void createSticker(InputStream inputStream, String fileName, String legend) throws Exception {
        BufferedImage originalImage = ImageIO.read(inputStream);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 100;
        
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 32);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        int legendWidth = graphics.getFontMetrics().stringWidth(legend);
        
        graphics.drawString(legend, (width / 2) - (legendWidth / 2), newHeight - 50);

        ImageIO.write(newImage, "png", new File(fileName));
    }
}
