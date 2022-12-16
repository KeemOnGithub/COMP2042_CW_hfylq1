# 2048
## Information
- Student Name: Luqmanul Hakeem Bin Qhaireel Anwar
- Student ID: 20299396
## Project Description
A Java version of the open-source game 2048, taken from a source file and refactored for better encapsulation and a user-friendly UI!
## How do I run this?
1. Create a new JavaFX file 
    - if using IntelliJ, you can create the tutorial Demo file, then switch out the files in the tutorial com.example.demo folder with the files in com.example.game.
    - if using Eclipse, you will have to open the project and download the JavaFX libraries.
2. Run Main!
## Implemented features
- Working properly
    - Start menu
        - Using FXML
        - New controller 'MenuController' added
    - Theme menu with different background colors
        - Using FXML
        - New controller 'ThemeController' added
    - Back button in gameScene
        - Must be clicked using cursor, Enter key doesn't work with it
    - App resizing by user disabled
        - To ensure game aesthetic is maintained
    - Background music added
    - Score moved to bottom
    - Tiles centered
      
## Features not implemented
- Account
    - For a simple game to play when bored, having an account system seems too much

## Key changes not mentioned above
- New class implemented
    - MoveBoxes, a class containing the methods relating to moving cells
        - Done to decrease size of gameScene
- Simplified if statements 
- Unnecessary import statements removed

## New Java classes made
- MoveBoxes
- MenuController
- ThemeController

## Modified Java classes
- Main
  - will launch menuScene, not gameScene
  - start function used to launch menuScene.fxml
  - fields HEIGHT, WIDTH, game, gameRoot, endgameRoot, endGameScene, gameScene moved to MenuCOntroller
- GameScene
  - Back button created in method 'game'
  - variable leftSpacing created to reposition cells
  - Fields 'text' and 'scoreText' relocated
-EndGame
  - Unused parameters removed from method endGameScene
  
