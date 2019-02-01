package com.bradburzon.controller;

import com.bradburzon.model.GameModel;
import com.bradburzon.model.Player;

/*
GameController
* As the game, I can choose to be player X or O.
* **** 1 player or 2 player game? generate AI???
* As the game, I can choose who goes first.
* As the game, I should be able to check the status of the board.
* As the game, I should be able to make a new game.
* As the game, I should be able to reset the game.
* As the game, I should be able to make a move.
 */
public class GameController {
	
	private GameModel gameModel;
	private Player currentPlayer;
	private Player nextPlayer;
	
	
	public GameController(GameModel gameModel) {
		this.gameModel = gameModel; //new GameModel(Player, Player)
		//initiate() need to ask what letter player 1 is
		currentPlayer = gameModel.getPlayer1();
		nextPlayer = gameModel.getPlayer2();
	}
	
	/**
	 * Resets the game including the board, score, and previous moves. 
	 */
	public void resetGame() {
		
	}
	
	/**
	 * Creates a new game while keeping the score....
	 */
	public void newGame() {
		
	}
	
	/**
	 * Lets the currentPlayer to make a move on the board
	 */
	public void move() {
		
	}
	
	/**
	 * Swap the currentPlayer and nextPlayer
	 */
	public void switchPlayer() {
		
	}
	
	/**
	 * Checks if there is a winner or not
	 * @return The status of the board if one of the player has won or there is no winner
	 */
	public boolean checkBoardStatus(){
		return false;
	}
	/*
	public void initiate() {
		
	}
	*/
	
}
