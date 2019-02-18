package com.bradburzon.view;

import com.bradburzon.controller.GameController;
import com.bradburzon.model.GameModel;

/*
•As the game, I should be able to print the board.
•As the game, I should be able to show the score.
•As the game, I should be able to rerender the board. ??? like maybe update()??
•As the game, I should be able to print help.

 */
public class GameView {
	GameController gameController; //will have the Board

	public GameView(GameController gameController) {
		this.gameController = gameController;
	}

	/**
	 * Prints the tic tac toe board 
	 * @return The string containing the board
	 */
	public void printBoard() {
		String header = "--------------------\n";
		String footer = "";
		

		header += gameController.getCurrentPlayer().getLetter().asLetter() + "'s Turn.";

		footer = "\nButtons: 1-9, H for Help, S to switch order, R to reset game,";
		char[][] board = gameController.getGameModel().getBoard();
		System.out.println(header);
		printScore();
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

	public void printScore() {
		char player1 = gameController.getGameModel().getPlayer1().getLetter().asLetter();
		char player2 = gameController.getGameModel().getPlayer2().getLetter().asLetter();
		String score = "Score: " + player1 + "-" + gameController.getGameModel().getScores().get(gameController.getGameModel().getPlayer1()) + " | " 
				+ player2 + "-" + gameController.getGameModel().getScores().get(gameController.getGameModel().getPlayer2()) + "\n";
		System.out.print(score);
	}

	public void printWinner(char c) {
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
	public void printHelp(){
		System.out.println(" \nTicTacToe"
				+ "\nThe object of Tic Tac Toe is to get three in a row."
				+ "\nYou play on a three by three game board. The first player"
				+ "\nis known as X and the second is O. Players alternate"
				+ "\nplacing X's and O's on the game board until either opponent "
				+ "\nhas three in a row or all nine squares are filled. "
				+ "\n(http://web.cecs.pdx.edu/~bart/cs541-fall2001/homework/tictactoe-rules.html)\n"
				+ "\nHelp(Press Enter after 1 key event)"
				+ "\n1-9 to pick place on the board to place your letter and then press enter."
				+ "\nH to bring out rules and help"
				+ "\nR to reset the game"
				+ "\nS to switch sides");
	}
}
