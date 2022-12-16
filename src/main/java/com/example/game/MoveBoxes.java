package com.example.game;

/**
 * This class contains methods responsible for moving cells horizontally and vertically.
 *
 */
public class MoveBoxes {
    private GameScene gameScene;

    /**
     * This constructor method is used to avoid stack overflow errors with the GameScene class.
     * In this, MoveBoxes is specified as the dependent class.
     *
     * @param parent the parent class GameScene.
     */
    public MoveBoxes(GameScene parent) {
        this.gameScene = parent;
    }

    /**
     * This method calls the method {@link #moveHorizontally(int, int, int, int)} for every cell and uses the sign value -1,
     * causing them to move to the left if able when the left arrow key is pressed.
     *
     */
    public void moveLeft() {
        for (int i = 0; i < gameScene.n; i++) {
            for (int j = 1; j < gameScene.n; j++) {
                moveHorizontally(i, j, gameScene.passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < gameScene.n; j++) {
                gameScene.cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This method calls the method {@link #moveHorizontally(int, int, int, int)} for every cell and uses the sign value 1,
     * causing them to move to the right if able when the right arrow key is pressed.
     *
     */
    public void moveRight() {
        for (int i = 0; i < gameScene.n; i++) {
            for (int j = gameScene.n - 1; j >= 0; j--) {
                moveHorizontally(i, j, gameScene.passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < gameScene.n; j++) {
                gameScene.cells[i][j].setModify(false);
            }
        }
    }

    /**
     * This method calls the method {@link #moveVertically(int, int, int, int)}  for every cell and uses the sign value -1,
     * causing them to move upwards if able when the up arrow key is pressed.
     *
     */
    public void moveUp() {
        for (int j = 0; j < gameScene.n; j++) {
            for (int i = 1; i < gameScene.n; i++) {
                moveVertically(i, j, gameScene.passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < gameScene.n; i++) {
                gameScene.cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This method calls the method {@link #moveVertically(int, int, int, int)}  for every cell and uses the sign value 1,
     * causing them to move downwards if able when the down arrow key is pressed.
     *
     */
    public void moveDown() {
        for (int j = 0; j < gameScene.n; j++) {
            for (int i = gameScene.n - 1; i >= 0; i--) {
                moveVertically(i, j, gameScene.passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < gameScene.n; i++) {
                gameScene.cells[i][j].setModify(false);
            }
        }

    }

    /**
     * This method checks if a cell can move horizontally.
     *
     * @param i cell row value given by {@link #moveHorizontally(int, int, int, int)}
     * @param j cell column value given by {@link #moveHorizontally(int, int, int, int)}
     * @param des the des value of {@link #moveHorizontally(int, int, int, int)}
     * @param sign the sign value given by {@link #moveHorizontally(int, int, int, int)}
     * @return true if possible, false if not
     */
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < gameScene.n && des + sign >= 0) {
            if (gameScene.cells[i][des + sign].getNumber() == gameScene.cells[i][j].getNumber() && !gameScene.cells[i][des + sign].getModify()
                    && gameScene.cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method will move the cells by (des + sign) units if the conditions of
     * {@link #isValidDesH(int, int, int, int)} are valid.
     *
     * @param i cell row value given by {@link #moveLeft()} or {@link #moveRight()}
     * @param j cell column value given by {@link #moveLeft()} or {@link #moveRight()}
     * @param des the coordinate or -1 value given by {@link GameScene#passDestination(int, int, char)}
     * @param sign the value given by {@link #moveLeft()} or {@link #moveRight()}
     */
    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            gameScene.cells[i][j].adder(gameScene.cells[i][des + sign]);
            gameScene.cells[i][des].setModify(true);
        } else if (des != j) {
            gameScene.cells[i][j].changeCell(gameScene.cells[i][des]);
        }
    }

    /**
     * This method checks if a cell can move vertically.
     *
     * @param i cell row value given by {@link #moveVertically (int, int, int, int)}
     * @param j cell column value given by {@link #moveVertically(int, int, int, int)}
     * @param des the des value of {@link #moveVertically(int, int, int, int)}
     * @param sign the sign value given by {@link #moveVertically(int, int, int, int)}
     * @return true if possible, false if not
     */
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < gameScene.n && des + sign >= 0)
            if (gameScene.cells[des + sign][j].getNumber() == gameScene.cells[i][j].getNumber() && !gameScene.cells[des + sign][j].getModify()
                    && gameScene.cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    /**
     * This method will move the cells by (des + sign) units if the conditions of
     * {@link #isValidDesV(int, int, int, int)} are valid.
     *
     * @param i cell row value given by {@link #moveUp()} or {@link #moveDown()}
     * @param j cell column value given by {@link #moveUp()} or {@link #moveDown()}
     * @param des the coordinate or -1 value given by {@link GameScene#passDestination(int, int, char)}
     * @param sign will move cell downwards if equals 1, will move cell upwards if equals -1
     */
    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            gameScene.cells[i][j].adder(gameScene.cells[des + sign][j]);
            gameScene.cells[des][j].setModify(true);
        } else if (des != i) {
            gameScene.cells[i][j].changeCell(gameScene.cells[des][j]);
        }
    }
}
