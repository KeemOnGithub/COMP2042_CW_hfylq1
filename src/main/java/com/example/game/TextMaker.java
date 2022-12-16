package com.example.game;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This is a singleton class which creates the numerical text within the cells.
 *
 */
class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     * Ensures only a single instance og TextMaker is made
     *
     * @return singleInstance, a single instance of TextMaker
     */
    static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * This method will input the text and position it in the rectangle.
     *
     * @param input the text to be inputted
     * @param xCell the x value of the cell given
     * @param yCell the y value of the cell given
     * @return the text object created.
     */
    Text madeText(String input, double xCell, double yCell) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
