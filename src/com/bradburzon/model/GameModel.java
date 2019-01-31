package com.bradburzon.model;

import java.util.HashMap;

/*
* As the game, I should be able to track the num of moves.
* As the game, I should be able to keep score.
* As the game, I should be able to keep track of the players.
** As the game, I should be able to keep track of the board.
** As the game, I should be able to know the rules and help.
 */
public class GameModel {
	
	private final Player player1;
	private final Player player2;
	private int[] player1Moves;
	private int[] player2Moves;
	private HashMap<Player, Integer> scores;
	private int[][] board; //need a board
	private final String rulesAndHelp;
	
	public GameModel(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		player1Moves = new int[5];
		player2Moves = new int[5];
		scores = new HashMap<Player, Integer>();
		scores.put(player1, 0);
		scores.put(player2, 0);
		rulesAndHelp = "";
	}
}
