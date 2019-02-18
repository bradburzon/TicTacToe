package com.bradburzon.model;

public enum Letter {
	X('X'), O('O');
	
	private final char playerLetter;
	
	Letter(char playerLetter) {
		this.playerLetter = playerLetter;
	}
	
	public char asLetter() {
		return playerLetter;
	}

}
