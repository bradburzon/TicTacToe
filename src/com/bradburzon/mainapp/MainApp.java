package com.bradburzon.mainapp;

import java.util.Scanner;

import com.bradburzon.controller.GameController;
import com.bradburzon.model.GameModel;
import com.bradburzon.view.GameView;

public class MainApp {

	GameController gameController;
	GameView gameView;
	GameModel gameModel;

	public MainApp() {
		gameModel = new GameModel();
		gameController = new GameController(gameModel);
		gameView = new GameView(gameController);
	}

	/**
	 * initiate the game
	 */
	public void play() {
		gameView.printBoard();
		userInput();
	}
	
	/**
	 * asks user for input and takes the first character
	 * 1-9 - valid move
	 * h - help
	 * s - switch players
	 * r - reset game
	 * q - quit game, show final score
	 */
	private void userInput() {
		Scanner input = new Scanner(System.in);
		try {
			if(input.hasNextInt()) {
				gameController.makeAMove(input.nextInt());
				if(gameController.checkWin(gameController.getNextPlayer())) {
					gameView.printWinner(gameController.getNextPlayer().getLetter().asLetter());
					gameController.resetGame();
					play();
				} else {
					play();
				}
			} else {
				char c = input.next().charAt(0);
				if(c == 'q') {
					gameView.printScore();
				} else if(c == 'r') {
					gameController.resetGame();
					System.out.println("\nGAME RESETTED\n");
					play();
				} else if(c == 'h') {
					gameView.printHelp();
					play();
				} else if(c == 's') {;
					gameController.switchPlayer();
					play();
				} else {
					userInput();
				}
			}
		} catch(Exception e) {
			System.out.println("\n***" + e.getMessage());
			play();
		}
		input.close();
	}

	public static void main(String[] args) {
		MainApp ticTacToe = new MainApp();
		ticTacToe.play();
	}
}
