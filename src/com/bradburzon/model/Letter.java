package com.bradburzon.model;

public enum Player {
	X('X'), O('O');
	
	private final char playerLetter;
	
	Player(char playerLetter) {
		this.playerLetter = playerLetter;
	}
	
	public char asLetter() {
		return playerLetter;
	}
}
