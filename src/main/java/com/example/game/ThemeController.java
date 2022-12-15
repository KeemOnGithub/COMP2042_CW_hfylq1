package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;

import java.io.IOException;

public class ThemeController {
    MenuController mc = new MenuController();

    @FXML
    protected void btnGreen(){

    }

    @FXML
    protected void OnThemeGreenClick(ActionEvent e) throws IOException {
        mc.OnStartButtonClick(e);
        //LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        mc.gameScene.setFill(Color.rgb(119, 221, 119));
    }

    @FXML
    protected void btnCream(){

    }

    @FXML
    protected void OnThemeCreamClick(ActionEvent e) throws IOException {
        mc.OnStartButtonClick(e);
        mc.gameScene.setFill(Color.rgb( 255, 253, 208));
    }

    @FXML
    protected void btnBlue(){

    }

    @FXML
    protected void OnThemeBlueClick(ActionEvent e) throws IOException {
        mc.OnStartButtonClick(e);
        mc.gameScene.setFill(Color.rgb( 179, 206, 229));
    }

    @FXML
    protected void btnGold(){

    }

    @FXML
    protected void OnThemeGoldClick(ActionEvent e) throws IOException {
        mc.OnStartButtonClick(e);
        mc.gameScene.setFill(Color.rgb(237, 198, 61));
    }

    @FXML
    protected void OnBackButtonClick(ActionEvent e) throws IOException {
        Stage stage = Main.get_theStage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuScene.fxml"));
        Scene menu = new Scene(fxmlLoader.load(), 600, 400);

        Main.get_theStage().setTitle("2048");
        stage.setScene(menu);
        stage.show();
    }


}
