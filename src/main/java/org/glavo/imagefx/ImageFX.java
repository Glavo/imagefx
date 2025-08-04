package org.glavo.imagefx;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import org.glavo.imagefx.apng.Png;
import org.glavo.imagefx.apng.argb8888.Argb8888Bitmap;
import org.glavo.imagefx.apng.error.PngException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Glavo
 */
public final class ImageFX {

    public static Image loadApngImage(InputStream inputStream) throws IOException {
        try {
            var sequence = Png.readArgb8888BitmapSequence(inputStream);
            if (sequence.isAnimated()) {
                var frames = sequence.getAnimationFrames();


                return null; // TODO
            } else {
                Argb8888Bitmap defaultImage = sequence.defaultImage;
                WritableImage image = new WritableImage(defaultImage.getWidth(), defaultImage.getHeight());
                image.getPixelWriter().setPixels(0, 0, defaultImage.getWidth(), defaultImage.getHeight(),
                        PixelFormat.getIntArgbInstance(), defaultImage.getPixelArray(),
                        0, defaultImage.getWidth());
                return image;
            }

        } catch (PngException e) {
            throw new IOException(e);
        }
    }

    private ImageFX() {
    }
}
