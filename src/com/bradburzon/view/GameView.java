package com.bradburzon.view;

import com.bradburzon.controller.GameController;

/*
�As the game, I should be able to print the board.
�As the game, I should be able to show the score.
�As the game, I should be able to rerender the board. ??? like maybe update()??
�As the game, I should be able to print help.

 */
public class GameView {

	public GameView() {
	}

	/**
	 * Prints the tic tac toe board 
	 * @return The string containing the board
	 */
	public void printBoard(GameController gameController) {
		String header = "--------------------\n";
		String footer = "";
		

		header += gameController.getCurrentPlayer().getLetter().asLetter() + "'s Turn. ";

		footer = "Buttons: 1-9, H for Help, S to switch order, R to reset game, Q to quit.";
		char[][] board = gameController.getGameModel().getBoard();
		System.out.print(header);
		printScore(gameController);
		int spot = 1;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j <  board.length; j++) {
				System.out.print("[" + board[i][j] + "]");
				if(j == 2) {
					System.out.print("       [" + spot++ + "]" +"[" + spot++ + "]" +"[" + spot++ + "]");
				}
				
			}
			System.out.println();
		}
		System.out.println(footer);
	}

	public void printScore(GameController gameController) {
		char player1 = gameController.getGameModel().getPlayer1().getLetter().asLetter();
		char player2 = gameController.getGameModel().getPlayer2().getLetter().asLetter();
		String score = "Score: " + player1 + "-" + gameController.getGameModel().getScores().get(gameController.getGameModel().getPlayer1()) + " | " 
				+ player2 + "-" + gameController.getGameModel().getScores().get(gameController.getGameModel().getPlayer2()) + "\n";
		System.out.print(score);
	}

	public void printWinner(GameController gameController, char c) {
		String winner = "***" + c + " has won!\n";
		for(char[] i : gameController.getGameModel().getBoard()) {
			for(char j : i) {
				if(j == c) {
					System.out.print("[" + j + "]" );
				} else {
					System.out.print("[ " + "]");
				}
			}
			System.out.println();
		}
		System.out.println("\n" + winner);
	}

	/**
	 * Prints the rules and help
	 * @return The string value of help
	 */
	public void printHelp(GameController gameController){
		System.out.println(gameController.getGameModel().getRulesAndHelp());
	}

	public void printTie() {
		System.out.println("***Game is TIED");
	}
}
