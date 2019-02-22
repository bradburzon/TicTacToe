package com.bradburzon.controller;

import com.bradburzon.model.GameModel;
import com.bradburzon.model.Player;
import com.bradburzon.view.GameView;

/*
GameController
 * As the game, I can choose to be player X or O.
 * As the game, I should be able to check the status of the board.
 * As the game, I should be able to make a new game.
 * As the game, I should be able to reset the game.
 * As the game, I should be able to make a move.
 */
public class GameController {

	private GameModel gameModel;
	private GameView gameView;
	private Player currentPlayer;

	public GameController(GameModel gameModel, GameView gameView) {
		this.gameModel = gameModel; //new GameModel(Player, Player)
		this.gameView = gameView;
		//initiate() need to ask what letter player 1 is
		currentPlayer = gameModel.getPlayer1();
	}

	public GameController() {
		this(new GameModel(), new GameView());
	}

	public void makeAMove(char move) throws IllegalArgumentException {

		if(Character.isDigit(move)) {
			move(Character.getNumericValue(move));
			if(checkBoardStatus() == 1) {
				gameView.printWinner(this, currentPlayer.getLetter().asLetter());
				gameModel.getScores().put(getCurrentPlayer(), gameModel.getScores().get(getCurrentPlayer()) + 1);
				resetGame();
			} else if(checkBoardStatus() == 2){
				gameView.printTie();
				resetGame();
			} else {
				switchPlayer();
			}
		} else if(Character.isLetter(move)) {
			if(move == 'h') {
				gameView.printHelp(this);
			} else if(move == 'r') {
				resetGame();
			} else if(move == 's') {
				if(currentPlayer.getTurn() == 0 && getNextPlayer().getTurn() == 0) {
					switchPlayer();
				} else {
					throw new IllegalArgumentException("***Cannot switch in the middle of the game!");
				}
			} else {
				throw new IllegalArgumentException("***Move is illegal.");
			}
		}

	}

	/**
	 * Lets the currentPlayer to make a move on the board
	 */
	public void move(int move) throws IllegalArgumentException { 
		if(move >= 1 && move <= 9 &&!moveExist(move)){	//out of bounds 
			int x = getX(move);
			int y = getY(move, x);
			int turn = currentPlayer.getTurn();
			currentPlayer.getMoves()[turn] = move;
			currentPlayer.setTurn(turn + 1);
			gameModel.getBoard()[x][y] = currentPlayer.getLetter().asLetter();
		} else {
			throw new IllegalArgumentException("***Move is OUT-OF-BOUNDS or AlREADY TAKEN");
		}
	}

	/**
	 * checks if the given x exists in the players move
	 * @param x
	 * @return true if move exists
	 */
	private boolean moveExist(int x){
		for(int m : gameModel.getPlayer1().getMoves()) {
			if (x == m) {
				return true;
			}
		}
		for(int m : gameModel.getPlayer2().getMoves()) {
			if (x == m) {
				return true;
			}
		}
		return false;	
	}

	/**
	 * 
	 * @param move the position on the board
	 * @return the x coord of the move
	 */
	public int getX(int move){
		return (int)Math.ceil((move - 1) / 3);
	}

	/**
	 * 
	 * @param move the position on the board
	 * @return the y coord of the move
	 */
	public int getY(int move, int xCoord){
		return (move - xCoord * 3) - 1;
	}

	/**
	 * Resets the game including the board, and previous moves. 
	 */
	public void resetGame() {
		char[][] newBoard =new char[3][3];
		gameModel.setBoard(newBoard);
		gameModel.getPlayer1().setTurn(0);
		gameModel.getPlayer2().setTurn(0);
		int[] moves1 = new int[] {-1, -1, -1, -1, -1};
		int[] moves2 = new int[] {-1, -1, -1, -1, -1};
		gameModel.getPlayer1().setMoves(moves1);
		gameModel.getPlayer2().setMoves(moves2);
		currentPlayer = gameModel.getPlayer1();
	}

	/**
	 * Swap the currentPlayer and nextPlayer
	 */
	public void switchPlayer() {
		currentPlayer = getNextPlayer();
	}

	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @return the nextPlayer
	 */
	public Player getNextPlayer() {
		if(gameModel.getPlayer1() == currentPlayer) {
			return gameModel.getPlayer2();
		}
		return gameModel.getPlayer1();
	}

	/**
	 * Checks if there is a winner or not
	 * @return The status of the board if one of the player has won or there is no winner
	 */
	public int checkBoardStatus(){
		if(checkWin(currentPlayer)) {
			return 1;
		} else if(currentPlayer.getTurn() + getNextPlayer().getTurn() == 9) {
			return 2;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param currPlayer
	 * @return true if player has occupied 3 spaces in horizontally, diagonally, or vertically
	 */
	public boolean checkWin(Player currPlayer) {
		boolean won = false;
		int[] moves = currPlayer.getMoves();
		if(containsAll(moves, 1, 2, 3)) {
			won = true;
		} else if (containsAll(moves, 4, 5, 6)) {
			won = true;
		}else if (containsAll(moves, 3, 5, 7)) {
			won = true;
		}else if (containsAll(moves, 7, 8, 9)) {
			won = true;
		}else if (containsAll(moves, 1, 4, 7)) {
			won = true;
		}else if (containsAll(moves, 2, 5, 8)) {
			won = true;
		}else if (containsAll(moves, 3, 6, 9)) {
			won = true;
		}else if (containsAll(moves, 1, 5, 9)) {
			won = true;
		}
		return won;
	}

	/**
	 * checks if i j k are inside the array moves
	 * @param moves int[]
	 * @param i int 
	 * @param j int 
	 * @param k int
	 * @return true if [i, j, k] is a subset of moves
	 */
	private boolean containsAll(int[] moves, int i, int j, int k) {
		if(contains(moves, i) && contains(moves, j) && contains(moves, k)) {
			return true;
		}
		return false;
	}

	/**
	 * checks if i is in moves
	 * @param moves
	 * @param i
	 * @return true if i is member of moves
	 */
	private boolean contains(int[] moves, int i) {
		for(int m : moves) {
			if(m == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the gameModel
	 */
	public GameModel getGameModel() {
		return gameModel;
	}

	/**
	 * @return the gameView
	 */
	public GameView getGameView() {
		return gameView;
	}

}
