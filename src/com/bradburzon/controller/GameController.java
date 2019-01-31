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
	
	GameModel gameModel;
	Player currentPlayer;
	
	
	public GameController(GameModel gameModel) {
		this.gameModel = gameModel;
	}
	
	/*
	public void initiate() {
		
	}
	*/
	
}
