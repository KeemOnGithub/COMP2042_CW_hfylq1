package com.example.game;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

/**
 * This class is responsible for running gameScene, and also for  certain cell operations such as assigning values.
 *
 */

class GameScene {
    private MoveBoxes box;

    /**
     * This constructor method is used to avoid circular dependency errors with the MoveBoxes class.
     * In this, GameScene is specified as the parent class.
     *
     */
    public GameScene(){
        this.box = new MoveBoxes(this);
    }

    private static int HEIGHT = 500;
    public static int n = 4;
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    public Cell[][] cells = new Cell[n][n];
    private Group root;
    private long score = 0;

    static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    static double getLENGTH() {
        return LENGTH;
    }

    /**
     * This method is responsible for generating the values of each newly generated cell,
     * where aForBound corresponds to the row value of emptyCells and bForBound corresponds to
     * the column value. These are then put into a random number generator to assign values 2 or 4 to new cells.
     *
     */
    private void randomFillNumber() {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0; //row
        int b = 0; //column
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }

        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    /**
     * This method is to check if the cell contains the number 0, 2048 or otherwise.
     *
     * @return 1 if the cell contains 0, 0 if it contains 2048 and 1 if it contains any other number.
     */
    private int  haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

    /**
     * This method will return the cell coordinate depending on the arrow direction clicked by the user.
     * The return value is used in {@link MoveBoxes#moveDown()}, {@link MoveBoxes#moveUp()},
     * {@link MoveBoxes#moveLeft()} and {@link MoveBoxes#moveRight()} to allow movement of cells.
     *
     * @param i an integer assigned when the function is called
     * @param j an integer assigned when the function is called
     * @param direct a character corresponding to arrow direction
     * @return cell coordinate or -1 if direct does not equal the required values
     */
    public int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * This method checks if adjacent cells have the same number.
     * @param i row value of cell
     * @param j column value of cell
     * @return true if numbers of cells are the same, false if not.
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    /**
     * This method checks if cells can move into another cell when an arrow key is pressed
     * using the method {@link #haveSameNumberNearly(int, int)}.
     *
     * @return false if adjacent cells are the same number, true if they do not.
     */
    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method calculates the current player's score by adding all the values of cells that
     * have been generated.
     *
     */
    private void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }

    /**
     * This method is responsible for creating and displaying the objects in gameScene by making them
     * children of root.
     *
     * @param gameScene a JavaFX scene where gameplay occurs
     * @param root the root node where all the objects in gameScene are assigned to as child nodes
     * @param primaryStage the stage where the gameScene and endGameScene are inserted
     * @param endGameScene scene which opens once cells can no longer move. Will display a GAME OVER message.
     * @param endGameRoot root node for endGameScene.
     */
    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int leftSpacing = 150;
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells + leftSpacing,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }
        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(250,550);

        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(450,567);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        Button back = new Button("Back to Menu");
        back.setFocusTraversable(false);
        back.relocate(100,600);
        root.getChildren().add(back);
        back.setOnAction(actionEvent -> {
            Stage stage = Main.get_theStage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuScene.fxml"));
            Scene menu = null;
            try {
                menu = new Scene(fxmlLoader.load(), 600, 400);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            Main.get_theStage().setTitle("2048");
            stage.setScene(menu);
            stage.show();
        });


        randomFillNumber();
        randomFillNumber();

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            int haveEmptyCell;
            if (key.getCode() == KeyCode.DOWN) {
                box.moveDown();
            } else if (key.getCode() == KeyCode.UP) {
                box.moveUp();
            } else if (key.getCode() == KeyCode.LEFT) {
                box.moveLeft();
            } else if (key.getCode() == KeyCode.RIGHT) {
                box.moveRight();
            }
            GameScene.this.sumCellNumbersToScore();
            scoreText.setText(score + "");
            haveEmptyCell = GameScene.this.haveEmptyCell();
            if (haveEmptyCell == -1) {
                if (GameScene.this.canNotMove()) {
                    primaryStage.setScene(endGameScene);

                    EndGame.getInstance().endGameShow(endGameRoot, score);
                    root.getChildren().clear();
                    score = 0;
                }
            } else if(haveEmptyCell == 1)
                GameScene.this.randomFillNumber();
        }));
    }
}
