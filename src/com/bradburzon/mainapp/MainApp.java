package com.bradburzon.mainapp;

import java.util.Scanner;

import com.bradburzon.controller.GameController;
import com.bradburzon.model.GameModel;
import com.bradburzon.view.GameView;

public class MainApp {

	GameController gameController;

	public MainApp() {
		gameController = new GameController(new GameModel(), new GameView());
	}

	/**
	 * initiate the game
	 */
	public void play() {
		gameController.getGameView().printBoard(gameController);
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
			while(input.hasNext()) {
				char c = input.next().charAt(0);
				if (c != 'q') {
					gameController.makeAMove(c);
					play();
				}
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			play();
		}
		input.close();
	}



	public static void main(String[] args) {
		MainApp ticTacToe = new MainApp();
		ticTacToe.play();
	}
}
