package com.bradburzon.controller;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bradburzon.model.GameModel;
import com.bradburzon.model.Letter;
import com.bradburzon.model.Player;
import com.bradburzon.view.GameView;


public class GameControllerTest {

	GameController gameController;

	/**
	 *  Test to make sure to get the right X
	 */
	@Test
	void getX_getTheXCoord() {
		gameController = new GameController(new GameModel());
		int expected = 0;
		int actual = gameController.getX(1);
		Assertions.assertEquals(expected, actual);
		expected = 0;
		actual = gameController.getX(3);
		Assertions.assertEquals(expected, actual);
		expected = 1;
		actual = gameController.getX(4);
		Assertions.assertEquals(expected, actual);
		expected = 1;
		actual = gameController.getX(6);
		Assertions.assertEquals(expected, actual);
		expected = 2;
		actual = gameController.getX(7);
		Assertions.assertEquals(expected, actual);
		expected = 2;
		actual = gameController.getX(9);
		Assertions.assertEquals(expected, actual);
	}

	/**
	 *  Test to make sure to get the right Y
	 */
	@Test
	void getY_getTheYCoord() {
		gameController = new GameController(new GameModel());
		int expected = 0;
		int actual = gameController.getY(1, 0);
		Assertions.assertEquals(expected, actual);
		expected = 2;
		actual = gameController.getY(3, 0);
		Assertions.assertEquals(expected, actual);
		expected = 0;
		actual = gameController.getY(4, 1);
		Assertions.assertEquals(expected, actual);
		expected = 2;
		actual = gameController.getY(6,1);
		Assertions.assertEquals(expected, actual);
		expected = 0;
		actual = gameController.getY(7, 2);
		Assertions.assertEquals(expected, actual);
		expected = 2;
		actual = gameController.getY(9, 2);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void switchPlayer_switchesToNexPlayer() {
		Player first = new Player(Letter.X);
		Player second = new Player(Letter.O);
		gameController = new GameController(new GameModel(first, second));
		
		gameController.switchPlayer();
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());
		gameController.switchPlayer();
		Assertions.assertEquals(first,  gameController.getCurrentPlayer());
		Assertions.assertEquals(second, gameController.getNextPlayer());
		gameController.switchPlayer();
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());
	}

	@Test
	void makeAMove_throwExceptionOutOfBounds() {
		gameController = new GameController(new GameModel());
		
		// CHECK FOR OUT OF BOUNDS
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove(0);
		});
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove(10);
		});
		
		//test 1 and 9
	}

	@Test 
	void makeAMove_throwExceptionMoveAlreadyExist() {
		gameController = new GameController (new GameModel());
		
		//CHECK IF MOVE HAS BEEN TAKEN
		gameController.makeAMove(1);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove(1);
		});
		gameController.makeAMove(2);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove(2);
		});
	}

	@Test 
	void makeAMove_KeepTrackOfTurnCorrectly() {
		gameController = new GameController(new GameModel());

		//Turn 0
		int expected1 = 0;
		int actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		int expected2 = 0;
		int actual2 = gameController.getNextPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		//Turn 1
		gameController.makeAMove(1);
		expected1 = 1;
		actual1 = gameController.getNextPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.makeAMove(2);
		expected2 = 1;
		actual2 = gameController.getNextPlayer().getTurn();
		//Turn 2
		gameController.makeAMove(3);
		expected1 = 2;
		actual1 = gameController.getNextPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.makeAMove(4);
		expected2 = 2;
		actual2 = gameController.getNextPlayer().getTurn();
	}

	@Test
	void makeAMove_storeMovesCorrectly(){
		gameController = new GameController(new GameModel());

		int move1 = 1;
		int[] moves = gameController.getCurrentPlayer().getMoves();
		Assertions.assertFalse(IntStream.of(moves).anyMatch(x -> x == move1)); //Make sure its not stored
		gameController.makeAMove(move1);
		moves = gameController.getNextPlayer().getMoves();
		Assertions.assertTrue(IntStream.of(moves).anyMatch(x -> x == move1)); //Make sure it is stored
		int move2 = 2;
		moves = gameController.getCurrentPlayer().getMoves();
		Assertions.assertFalse(IntStream.of(moves).anyMatch(x -> x == move2));
		gameController.makeAMove(move2);
		moves = gameController.getNextPlayer().getMoves();
		Assertions.assertTrue(IntStream.of(moves).anyMatch(x -> x == move2));
		int move3 = 3;
		moves = gameController.getCurrentPlayer().getMoves();
		Assertions.assertFalse(IntStream.of(moves).anyMatch(x -> x == move3));
		gameController.makeAMove(move3);
		moves = gameController.getNextPlayer().getMoves();
		Assertions.assertTrue(IntStream.of(moves).anyMatch(x -> x == move3));
	}

	@Test
	void makeAMove_populateASpaceInTheBoardCorrectly() {
		gameController = new GameController(new GameModel());
		
		char[][] board = gameController.getGameModel().getBoard();
		gameController.makeAMove(1);
		Assertions.assertEquals(board[0][0],  gameController.getNextPlayer().getLetter().asLetter()); 
		gameController.makeAMove(2);
		Assertions.assertEquals(board[0][1], gameController.getNextPlayer().getLetter().asLetter());
		gameController.makeAMove(9);
		Assertions.assertEquals(board[2][2], gameController.getNextPlayer().getLetter().asLetter());
	}
	
	@Test
	void checkWin_returnTrueWhenOnePlayerWins(){
		gameController = new GameController(new GameModel());
		int[] lose = new int[] {1, 3, 5};
		int[] win = new int[] {7, 8, 9, 4};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));
	}
	@Test
	void resetGame_resetsGameBoardTurnAndMovesAndResetCurrentPlayerToPlayer1() {
		gameController = new GameController(new GameModel());
		GameView gv= new GameView(gameController);
		gameController.makeAMove(1);
		gameController.makeAMove(3);
		gameController.makeAMove(5);
		gv.printBoard();
		gameController.resetGame();
		
		char[][] expectedBoard = new char[][] {{'1','2','3'},
			{'4','5','6'},
			{'7','8','9'}};
		int[] expectedMoves = new int[] {-1, -1, -1, -1, -1};
		int expectedTurn = 0;
		for(int i = 0; i <= 2; i++) {
			Assertions.assertTrue(Arrays.equals(expectedBoard[i], gameController.getGameModel().getBoard()[i]));
		}
		Assertions.assertTrue(Arrays.equals(expectedMoves, gameController.getGameModel().getPlayer1().getMoves()));
		Assertions.assertTrue(Arrays.equals(expectedMoves, gameController.getGameModel().getPlayer2().getMoves()));
		Assertions.assertEquals(expectedTurn, gameController.getGameModel().getPlayer1().getTurn());
		Assertions.assertEquals(expectedTurn, gameController.getGameModel().getPlayer2().getTurn());
	
		Assertions.assertEquals( gameController.getGameModel().getPlayer1(), gameController.getCurrentPlayer());
		Assertions.assertEquals(gameController.getGameModel().getPlayer2(), gameController.getNextPlayer());
	}
}
