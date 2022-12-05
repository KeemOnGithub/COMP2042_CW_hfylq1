package com.example.game;

public class MoveBoxes {
    private GameScene gameScene;

    public MoveBoxes(GameScene parent) {
        this.gameScene = parent;
    }

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

    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < gameScene.n && des + sign >= 0) {
            if (gameScene.cells[i][des + sign].getNumber() == gameScene.cells[i][j].getNumber() && !gameScene.cells[i][des + sign].getModify()
                    && gameScene.cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }

    private void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            gameScene.cells[i][j].adder(gameScene.cells[i][des + sign]);
            gameScene.cells[i][des].setModify(true);
        } else if (des != j) {
            gameScene.cells[i][j].changeCell(gameScene.cells[i][des]);
        }
    }

    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < gameScene.n && des + sign >= 0)
            if (gameScene.cells[des + sign][j].getNumber() == gameScene.cells[i][j].getNumber() && !gameScene.cells[des + sign][j].getModify()
                    && gameScene.cells[des + sign][j].getNumber() != 0) {
                return true;
            }
        return false;
    }

    private void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            gameScene.cells[i][j].adder(gameScene.cells[des + sign][j]);
            gameScene.cells[des][j].setModify(true);
        } else if (des != i) {
            gameScene.cells[i][j].changeCell(gameScene.cells[des][j]);
        }
    }
}
