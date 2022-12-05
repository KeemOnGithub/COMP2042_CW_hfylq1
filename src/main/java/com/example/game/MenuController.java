package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    static final int WIDTH = 800;
    static final int HEIGHT = 650;
    //Main main_stuff = new Main();

    @FXML
    protected void btnStart(){

    }

    @FXML
    protected void OnStartButtonClick(ActionEvent e) throws IOException {
        Stage stage = Main.get_theStage();
        stage.setX(200);
        stage.setY(0);
        GameScene game = new GameScene();
        Group gameRoot = new Group();
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

        //setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(237,198,61));
        //setGameScene(gameScene);
        stage.setScene(gameScene);

        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
    }

    @FXML
    protected void btnQuit(){

    }

    @FXML
    protected void OnQuitButtonClick(ActionEvent e) throws IOException {
        System.exit(0);
    }

    @FXML
    protected void btnTheme(){

    }

    @FXML
    protected void OnThemeButtonClick(ActionEvent e) throws IOException {

    }
}
