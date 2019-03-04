# Tic Tac Toe

A terminal based game for Tic Tac Toe using Model-View-Controller design pattern.

## Getting Started

These instructions will get you a copy of the game up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them

```
Java Development Kit (JDK)
Eclipse(optional)
```

### Installing

To install JDK follow this link here: [Installing JDK](https://www.codejava.net/java-core/how-to-write-compile-and-run-a-hello-world-java-program-for-beginners).
This guide is really great and easy to follow with pictures as well. 

And for Eclipse, go to [Eclipse Packages](https://www.eclipse.org/downloads/packages/) and heres a [table](https://www.eclipse.org/downloads/packages/compare) comparing the packages. 
If you are just running Java, just download [this](https://www.eclipse.org/downloads/packages/release/2018-12/r/eclipse-ide-java-developers).
You can always install more software to fit your needs later.

## Running the app

```
git clone https://github.com/bradburzon/TicTacToe.git
```
After this you need to go into the source directory and copy the javac to compile all necessary files. 
Lastly, run the java code to play the game. 

```
cd TicTacToe/src
javac com/bradburzon/model/Letter.java com/bradburzon/model/Player.java com/bradburzon/model/GameModel.java com/bradburzon/view/GameView.java  com/bradburzon/controller/GameController.java com/bradburzon/mainapp/MainApp.java

java com.bradburzon.mainapp.MainApp
```
Enjoy!

## Running the tests

Using Model-View-Controller design pattern, most of my logic are in Controller so run GameControllerTest.java in tst/com/bradburzon/controller. 

## Built With

* [Eclipse](https://www.eclipse.org/) - The Integrated Development Envirent(IDE) used
* [git](https://git-scm.com/) - committing

## Authors

* **Brad Burzon** - *Initial work* - [bradburzon](https://github.com/bradburzon)
* **Brandon Burzon** - *Initial work* - [brburzon](https://github.com/brburzon)


## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc


# USER STORIES

PlayerModel
* As a player, I should be able to keep my character.
* As a player, I should be able to keep track of my move.
* As a player, I should be able to keep my number of moves.

------------------------------------------------

GameModel
* As the game, I should be able to keep scores.
* As the game, I should be able to keep track of the players.
* As the game, I should be able to keep track of the board.
* As the game, I should be able to know the rules and help.

GameView
* As the game, I should be able to print the board.
* As the game, I should be able to show the score.
* As the game, I should be able to re-render the board.
* As the game, I should be able to print help.

GameController
* As the game, I should be able to check the status of the board.
* As the game, I should be able to reset the game.
* As the game, I should be able to make a move.
* As the game, I can choose switch players.

------------------------------------------------

MainApplication
* As the application, I should be able to play.
* As the application, I should be able to ask user for inputs.
* As the application, I should be able to quit.






