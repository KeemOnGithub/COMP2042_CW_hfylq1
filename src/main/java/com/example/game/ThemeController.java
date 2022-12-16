package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class contains methods for themeScene (changing background colors, going back to menuScene)
 *
 * @author Luqmanul Hakeem Bin Qhaireel Anwar
 */
public class ThemeController {
    MenuController menu = new MenuController();

    /**
     * A constructor method for the 'Green' button.
     *
     */
    @FXML
    protected void btnGreen(){

    }

    /**
     * This method will change the background color of gameScene to green when clicked.
     *
     */
    @FXML
    protected void OnThemeGreenClick() {
        menu.OnStartButtonClick();
        menu.gameScene.setFill(Color.rgb(119, 221, 119));
    }

    /**
     * A constructor method for the 'Cream' button.
     *
     */
    @FXML
    protected void btnCream(){

    }

    /**
     * This method will change the background color of gameScene to cream when clicked.
     *
     */
    @FXML
    protected void OnThemeCreamClick() {
        menu.OnStartButtonClick();
        menu.gameScene.setFill(Color.rgb( 255, 253, 208));
    }

    /**
     * A constructor method for the 'Blue' button.
     *
     */
    @FXML
    protected void btnBlue(){

    }

    /**
     * This method will change the background color of gameScene to blue when clicked.
     *
     */
    @FXML
    protected void OnThemeBlueClick() {
        menu.OnStartButtonClick();
        menu.gameScene.setFill(Color.rgb( 179, 206, 229));
    }

    /**
     * A constructor method for the 'Gold' button.
     *
     */
    @FXML
    protected void btnGold(){

    }

    /**
     * This method will change the background color of gameScene to gold when clicked.
     *
     */
    @FXML
    protected void OnThemeGoldClick() {
        menu.OnStartButtonClick();
        menu.gameScene.setFill(Color.rgb(237, 198, 61));
    }

    /**
     * This method loads menuScene and will show it when the Back button is clicked.
     *
     * @throws IOException
     */
    @FXML
    protected void OnBackButtonClick() throws IOException {
        Stage stage = Main.get_theStage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuScene.fxml"));
        Scene menu = new Scene(fxmlLoader.load(), 600, 400);

        Main.get_theStage().setTitle("2048");
        stage.setScene(menu);
        stage.show();
    }


}
