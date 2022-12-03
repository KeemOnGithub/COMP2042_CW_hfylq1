package com.example.demo;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Random;

public class menuScene {
    public Scene getScene() {
        VBox parent = new VBox();
        parent.getChildren().add(new Label("2048"));

        Button buttonStart = new Button("Start");
        parent.getChildren().add(buttonStart);
        return null;
    }
}
