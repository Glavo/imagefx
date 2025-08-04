package org.glavo.imagefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class ImageFXDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        Image image;
        try (var input = ImageFXDemo.class.getResourceAsStream("demo.png")) {
            image = ImageFX.loadApngImage(input);
        }

        ImageView view = new ImageView(image);
        Scene scene = new Scene(new StackPane(view), image.getWidth(), image.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
