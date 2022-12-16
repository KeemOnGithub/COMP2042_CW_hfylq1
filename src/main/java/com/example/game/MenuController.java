package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is a controller for menuScene.
 *
 * @author Luqmanul Hakeem Bin Qhaireel Anwar
 */
public class MenuController {
    static final int WIDTH = 800;
    static final int HEIGHT = 650;
    //Main main_stuff = new Main();
    GameScene game = new GameScene();
    Group gameRoot = new Group();
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

    //setGameRoot(gameRoot);
    Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(237,198,61));

    /**
     * A constructor method for a simple Start button.
     *
     */
    @FXML
    protected void btnStart(){

    }

    /**
     * This method gets the stage and opens the gameScene upon clicking btnStart.
     *
     */
    @FXML
    protected void OnStartButtonClick() {
        Stage stage = Main.get_theStage();
        stage.setX(200);
        stage.setY(0);

        //setGameScene(gameScene);
        stage.setScene(gameScene);

        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
    }

    /**
     * A constructor method for a simple Quit button.
     *
     */
    @FXML
    protected void btnQuit(){

    }

    /**
     * This method exits the program when btnQuit is clicked.
     *
     */
    @FXML
    protected void OnQuitButtonClick() {
        System.exit(0);
    }

    /**
     * A constructor method for a simple Theme button.
     *
     */
    @FXML
    protected void btnTheme(){

    }

    /**
     * This method changes the scene to themeScene when btnTheme is clicked.
     *
     */
    @FXML
    protected void OnThemeButtonClick() throws IOException {
        Stage stage = Main.get_theStage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("themeScene.fxml"));
        Scene themes = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("2048");
        stage.setScene(themes);
        stage.show();
    }
}
