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
	private HashMap<Player, Integer> scores;
	private char[][] board; //need a board
	private final String rulesAndHelp;

	public GameModel(Player player1, Player player2) {
		this.player1 = player1;  //seems like it will be better if I make a class Player with enum X and O member
		this.player2 = player2;
		scores = new HashMap<Player, Integer>();
		scores.put(player1, 0);
		scores.put(player2, 0);
		rulesAndHelp = "";
		board = new char[3][3];
	}

	public GameModel() {
		this(new Player(Letter.X), new Player(Letter.O));
	}

	/**
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @return the scores
	 */
	public HashMap<Player, Integer> getScores() {
		return scores;
	}

	/**
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * @return the rulesAndHelp
	 */
	public String getRulesAndHelp() {
		return rulesAndHelp;
	}
}
