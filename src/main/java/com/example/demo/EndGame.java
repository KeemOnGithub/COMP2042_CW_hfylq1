package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * This class is responsible for creating the endGameScene and its objects, while ensuring that only a
 * single instance of this runs at a time.
 *
 * @author Luqmanul Hakeem Bin Qhaireel Anwar-modified
 */
public class EndGame {
    private static EndGame singleInstance = null;

    /**
     * A constructor method for endGame.
     *
     */
    private EndGame(){

    }

    /**
     * This method creates an instance of endGame only if there are no instances of endGame currently running.
     *
     * @return singleInstance, which is a new object of EndGame().
     */
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     * This method is called by {@link GameScene#game(Scene, Group, Stage, Scene, Group)}. It is responsible for
     * creating the GAME OVER text, scoreText and Quit button and assigning them as child nodes of root.
     *
     * @param root the root of endGameScene from class GameScene. It is et as endGameRoot.
     * @param score the score obtained by the player.
     */
    public void endGameShow(Group root, long score){
        Text text = new Text("GAME OVER");
        text.relocate(180,200);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(280,400);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(330,500);
        quitButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Dialog");
            alert.setHeaderText("Quit from this page");
            alert.setContentText("Are you sure?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.exit(0);
            }
        });



    }
}
