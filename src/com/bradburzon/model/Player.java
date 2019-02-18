package com.bradburzon.model;

public class Player {
	
	private final Letter letter;
	private int[] moves;
	private int turn;
	
	public Player(Letter letter) {
		this.letter = letter;
		moves = new int[] {-1, -1, -1, -1, -1};
		turn = 0;
	}

	/**
	 * @return the letter
	 */
	public Letter getLetter() {
		return letter;
	}

	/**
	 * @return the moves
	 */
	public int[] getMoves() {
		return moves;
	}

	/**
	 * @return the turn
	 */
	public int getTurn() {
		return turn;
	}
	
	/**
	 *  the turn
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	/**
	 * change moves to new moves
	 * @param moves
	 */
	public void setMoves(int[] moves) {
		this.moves = moves;
	}
}
