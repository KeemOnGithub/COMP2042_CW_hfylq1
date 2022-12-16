package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;

/**
 * This class is responsible for creating the stage, opening the main menu and activating the background music.
 *
 * @author Luqmanul Hakeem Bin Qhaireel Anwar-modified
 *
 */

public class Main extends Application {
    private static Stage theStage;
    Media ost = new Media(getClass().getResource("/com/example/game/Thin Ice.mp3").toExternalForm());
    MediaPlayer mediaPlayer = new MediaPlayer(ost);

    /**
     * This method is a getter for 'theStage' variable, which is simply the name for the primary stage created later.
     *
     * @return theStage
     */
    public static Stage get_theStage() {
        return theStage;
    }

    /**
     * This method is responsible for creating the stage, disabling user resizing, loading and showing the main menu scene, and playing background music.
     *
     * @param primaryStage the stage created for our JavaFX program, which is assigned to theStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;
        theStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuScene.fxml"));
        Scene menu = new Scene(fxmlLoader.load(), 600, 400);
        mediaPlayer.play();

        theStage.setTitle("2048");
        theStage.setScene(menu);
        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
