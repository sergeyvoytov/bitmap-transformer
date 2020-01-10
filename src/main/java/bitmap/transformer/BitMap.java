package bitmap.transformer;

import java.awt.image.BufferedImage;

public class BitMap {

    private final BufferedImage img;

    public BitMap(BufferedImage img) {
        this.img = img;

    }
    BufferedImage convertToGrayscale(final BufferedImage img) {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int color = img.getRGB(i, j);

                int alpha = (color >> 24) & 255;
                int red = (color >> 16) & 255;
                int green = (color >> 8) & 255;
                int blue = (color) & 255;

                final int lum = (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);

                alpha = (alpha << 24);
                red = (lum << 16);
                green = (lum << 8);
                blue = lum;

                color = alpha + red + green + blue;

                img.setRGB(i, j, color);
            }

        }

        return img;
    }

}






