package com.bradburzon.view;

import com.bradburzon.controller.GameController;

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
	
	public String printBoard() {
		return "";
	}
	
	public String printHelp(){
		return "";
	}
}
