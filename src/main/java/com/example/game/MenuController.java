package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static final int WIDTH = 800;
    static final int HEIGHT = 650;
    Main main_stuff = new Main();

    @FXML
    protected void btnStart(){

    }

    @FXML
    protected void OnStartButtonClick(ActionEvent e) throws IOException {
        stage = main_stuff.get_theStage();
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

}
