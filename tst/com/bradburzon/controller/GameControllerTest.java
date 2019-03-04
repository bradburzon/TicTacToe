package com.bradburzon.controller;
import java.util.Arrays;
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
		gameController = new GameController(new GameModel(), new GameView());
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
		gameController = new GameController(new GameModel(), new GameView());
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

	/**
	 * Returns different board status based on the board
	 * 0 - Board is playable
	 * 1 - One player has won and board needs to reset
	 * 2 - Tie game and board is unplayable, need reset.
	 */
	@Test
	void checkBoardStatus_returnCorrectNumberAccordingToGameState() {
		gameController = new GameController(new GameModel(), new GameView());
		Assertions.assertEquals(0, gameController.checkBoardStatus());

		int[] winningMoves = new int[] {1, 2 , 3, -1, -1};
		gameController.getCurrentPlayer().setMoves(winningMoves);
		Assertions.assertEquals(1, gameController.checkBoardStatus());

		gameController.getCurrentPlayer().setMoves(new int[5]);
		gameController.getCurrentPlayer().setTurn(5);
		gameController.getNextPlayer().setTurn(4);
		Assertions.assertEquals(2, gameController.checkBoardStatus());
	}

	/**
	 * Checks if switches Player switches player accordingly
	 */
	@Test
	void switchPlayer_switchesToNexPlayer() {
		Player first = new Player(Letter.X);
		Player second = new Player(Letter.O);
		gameController = new GameController(new GameModel(first, second), new GameView());

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

	/**
	 * Tests if given move on the board is out of bounds and throws exception
	 *
	 * @throws IllegalArgumentException move is illegal
	 */

	@Test
	void move_throwExceptionOutOfBounds() throws IllegalArgumentException {
		gameController = new GameController(new GameModel(), new GameView());

		// CHECK FOR OUT OF BOUNDS
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(0);
		});
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(10);
		});

		gameController.move(1);
		Assertions.assertEquals(1, gameController.getCurrentPlayer().getMoves()[0]);
		Assertions.assertEquals(1, gameController.getCurrentPlayer().getTurn());
		Assertions.assertEquals('X', gameController.getGameModel().getBoard()[0][0]);
		gameController.switchPlayer();

		gameController.move(9);
		Assertions.assertEquals(9, gameController.getCurrentPlayer().getMoves()[0]);
		Assertions.assertEquals(1, gameController.getCurrentPlayer().getTurn());
		Assertions.assertEquals('O', gameController.getGameModel().getBoard()[2][2]);
	}

	/**
	 * Tests if move is taken already and throw exception
	 * @throws IllegalArgumentException move is illegal
	 */
	@Test 
	void move_throwExceptionMoveAlreadyExist() throws Exception {
		gameController = new GameController (new GameModel(), new GameView());

		//CHECK IF MOVE HAS BEEN TAKEN
		gameController.move(1);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(1);
		});
		gameController.switchPlayer();

		gameController.move(2);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(2);
		});
		gameController.switchPlayer();

		gameController.move(3);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(3);
		});
		gameController.switchPlayer();

		gameController.move(4);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(4);
		});
		gameController.switchPlayer();

		gameController.move(5);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(5);
		});
		gameController.switchPlayer();

		gameController.move(6);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(6);
		});
		gameController.switchPlayer();

		gameController.move(7);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(7);
		});
		gameController.switchPlayer();

		gameController.move(8);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(8);
		});
		gameController.switchPlayer();

		gameController.move(9);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.move(9);
		});
		gameController.switchPlayer();
	}

	/**
	 * Tests if move stores the turn of each play
	 */
	@Test 
	void move_KeepTrackOfTurnCorrectly() throws Exception {
		gameController = new GameController(new GameModel(), new GameView());

		//Turn 0
		int expected1 = 0;
		int actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		int expected2 = 0;
		int actual2 = gameController.getNextPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		//Turn 1 Player 1 & Player2
		gameController.move(1);
		expected1 = 1;
		actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.switchPlayer();

		gameController.move(2);
		expected2 = 1;
		actual2 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		gameController.switchPlayer();

		//Turn 2
		gameController.move(3);
		expected1 = 2;
		actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.switchPlayer();

		gameController.move(4);
		expected2 = 2;
		actual2 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		gameController.switchPlayer();

		//Turn 3
		gameController.move(5);
		expected1 = 3;
		actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.switchPlayer();

		gameController.move(6);
		expected2 = 3;
		actual2 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		gameController.switchPlayer();

		//Turn 4
		gameController.move(7);
		expected1 = 4;
		actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.switchPlayer();

		gameController.move(8);
		expected2 = 4;
		actual2 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected2, actual2);
		gameController.switchPlayer();

		//Turn 5
		gameController.move(9);
		expected1 = 5;
		actual1 = gameController.getCurrentPlayer().getTurn();
		Assertions.assertEquals(expected1, actual1);
		gameController.switchPlayer();
	}

	/**
	 * Tests if move stores player moves accordingly and correctly
	 */
	@Test
	void move_storeMovesAndInTheRightOrder(){
		gameController = new GameController(new GameModel(), new GameView());

		int move = 1;
		gameController.move(move);
		int playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move, playerMove); //Make sure it is stored in the right
		gameController.switchPlayer();

		int move2 = 2;
		gameController.move(move2);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move2, playerMove);
		gameController.switchPlayer();

		int move3 = 3;
		gameController.move(move3);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move3, playerMove);
		gameController.switchPlayer();

		int move4 = 4;
		gameController.move(move4);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move4, playerMove);
		gameController.switchPlayer();

		int move5 = 5;
		gameController.move(move5);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move5, playerMove);
		gameController.switchPlayer();

		int move6 = 6;
		gameController.move(move6);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move6, playerMove);
		gameController.switchPlayer();

		int move7 = 7;
		gameController.move(move7);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move7, playerMove);
		gameController.switchPlayer();

		int move8 = 8;
		gameController.move(move8);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move8, playerMove);
		gameController.switchPlayer();

		int move9 = 9;
		gameController.move(move9);
		playerMove = gameController.getCurrentPlayer().getMoves()[gameController.getCurrentPlayer().getTurn()-1];
		Assertions.assertEquals(move9, playerMove);
		gameController.switchPlayer();
	}

	/**
	 * Tests to see move puts the player Letter in the right spot
	 */
	@Test
	void move_populateASpaceInTheBoardCorrectly() {
		gameController = new GameController(new GameModel(), new GameView());

		char[][] board = gameController.getGameModel().getBoard();
		gameController.move(1);
		Assertions.assertEquals(board[0][0],  gameController.getCurrentPlayer().getLetter().asLetter()); 
		gameController.switchPlayer();

		gameController.move(2);
		Assertions.assertEquals(board[0][1], gameController.getCurrentPlayer().getLetter().asLetter());
		gameController.switchPlayer();

		gameController.move(9);
		Assertions.assertEquals(board[2][2], gameController.getCurrentPlayer().getLetter().asLetter());
		gameController.switchPlayer();
	}

	/**
	 * Tests the checkwin if it returns true for all winning set of moves and false for non winner
	 */
	@Test
	void checkWin_returnTrueWhenOnePlayerWins(){
		gameController = new GameController(new GameModel(), new GameView());
		int[] lose = new int[] {7, 6, 5, -1, -1};
		int[] win = new int[] {1, 2, 3, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {1, 3, 9, -1, -1};
		win = new int[] {4, 5, 6, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {1, 3, 5, -1, -1};
		win = new int[] {7, 8, 9, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {8, 3, 5, -1, -1};
		win = new int[] {7, 4, 1, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {1, 3, 9, -1, -1};
		win = new int[] {5, 2, 8, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {1, 4, 5, -1, -1};
		win = new int[] {3, 6, 9, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {1, 2, 4, -1, -1};
		win = new int[] {7, 5, 3, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));

		lose = new int[] {2, 3, 4, -1, -1};
		win = new int[] {9, 1, 5, -1, -1};
		gameController.getCurrentPlayer().setMoves(lose);
		gameController.getNextPlayer().setMoves(win);
		Assertions.assertTrue(gameController.checkWin(gameController.getNextPlayer()));
		Assertions.assertFalse(gameController.checkWin(gameController.getCurrentPlayer()));
	}
	
	/**
	 * Test to see resetGame resets the board, player's turns and moves properly
	 */
	@Test
	void resetGame_resetsGameBoardTurnAndMovesAndResetCurrentPlayerToPlayer1() {
		gameController = new GameController(new GameModel(), new GameView());
		gameController.move(1);
		gameController.switchPlayer();
		gameController.move(2);
		gameController.switchPlayer();
		gameController.move(3);
		gameController.switchPlayer();
		gameController.move(4);
		gameController.switchPlayer();
		gameController.move(5);
		gameController.switchPlayer();
		gameController.move(6);
		gameController.switchPlayer();
		gameController.move(7);
		gameController.resetGame();

		char[][] expectedBoard = new char[3][3];
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
	
	/**
	 * Tests if makeAMoves will throw exception when player tries to switch player in middle of Game
	 * @throws Exception cannot switch in middle of the game
	 */
	@Test
	void makeAMove_throwsExceptionWhenPlayerTriesToSwitchInMiddleOfGame() throws Exception {
		Player first = new Player(Letter.X);
		Player second = new Player(Letter.O);
		gameController = new GameController(new GameModel(first, second), new GameView());

		Assertions.assertEquals(0, first.getTurn());
		Assertions.assertEquals(0,second.getTurn());
		gameController.makeAMove('s');
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());

		first.setTurn(1);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove('s');;
		});

		first.setTurn(0);
		second.setTurn(1);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove('s');;
		});

		first.setTurn(1);
		second.setTurn(1);
		Assertions.assertThrows(Exception.class, () -> {
			gameController.makeAMove('s');;
		});
	}
	
	/**
	 * Tests if makeAMove adds score on the right player and accumulates correctly
	 * @throws Exception
	 */
	@Test
	void makeAMove_AddScoreWhenPlayerWins() throws Exception {
		gameController = new GameController(new GameModel(), new GameView());

		gameController.makeAMove('1');
		gameController.makeAMove('4');
		gameController.makeAMove('2');
		gameController.makeAMove('5');
		gameController.makeAMove('3');
		int scoreP1 = gameController.getGameModel().getScores().get(gameController.getCurrentPlayer().getLetter().asLetter());
		int scoreP2 = gameController.getGameModel().getScores().get(gameController.getNextPlayer().getLetter().asLetter());
		Assertions.assertEquals(1, scoreP1);
		Assertions.assertEquals(0, scoreP2);

		gameController.makeAMove('s');
		gameController.makeAMove('1');
		gameController.makeAMove('4');
		gameController.makeAMove('2');
		gameController.makeAMove('5');
		gameController.makeAMove('3');
		scoreP1 = gameController.getGameModel().getScores().get(gameController.getCurrentPlayer().getLetter().asLetter());
		scoreP2 = gameController.getGameModel().getScores().get(gameController.getNextPlayer().getLetter().asLetter());
		Assertions.assertEquals(1, scoreP1);
		Assertions.assertEquals(1, scoreP2);

		gameController.makeAMove('1');
		gameController.makeAMove('4');
		gameController.makeAMove('2');
		gameController.makeAMove('5');
		gameController.makeAMove('3');
		scoreP1 = gameController.getGameModel().getScores().get(gameController.getCurrentPlayer().getLetter().asLetter());
		scoreP2 = gameController.getGameModel().getScores().get(gameController.getNextPlayer().getLetter().asLetter());
		Assertions.assertEquals(2, scoreP1);
		Assertions.assertEquals(1, scoreP2);

		gameController.makeAMove('s');
		gameController.makeAMove('1');
		gameController.makeAMove('4');
		gameController.makeAMove('2');
		gameController.makeAMove('5');
		gameController.makeAMove('3');
		scoreP1 = gameController.getGameModel().getScores().get(gameController.getCurrentPlayer().getLetter().asLetter());
		scoreP2 = gameController.getGameModel().getScores().get(gameController.getNextPlayer().getLetter().asLetter());
		Assertions.assertEquals(2, scoreP1);
		Assertions.assertEquals(2, scoreP2);

		gameController.makeAMove('s');
		gameController.makeAMove('s');
		gameController.makeAMove('1');
		gameController.makeAMove('4');
		gameController.makeAMove('2');
		gameController.makeAMove('5');
		gameController.makeAMove('3');
		scoreP1 = gameController.getGameModel().getScores().get(gameController.getCurrentPlayer().getLetter().asLetter());
		scoreP2 = gameController.getGameModel().getScores().get(gameController.getNextPlayer().getLetter().asLetter());
		Assertions.assertEquals(3, scoreP1);
		Assertions.assertEquals(2, scoreP2);
	}
	
	/**
	 * Tests if every move switches players 
	 * @throws Exception
	 */
	@Test
	void makeAMove_SwitchPlayerAfterEveryMoveOnTheBoard() throws Exception {
		Player first = new Player(Letter.X);
		Player second = new Player(Letter.O);
		gameController = new GameController(new GameModel(first, second), new GameView());

		Assertions.assertEquals(first, gameController.getCurrentPlayer());
		Assertions.assertEquals(second, gameController.getNextPlayer());

		gameController.makeAMove('1');
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());

		gameController.makeAMove('2');
		Assertions.assertEquals(first, gameController.getCurrentPlayer());
		Assertions.assertEquals(second, gameController.getNextPlayer());

		gameController.makeAMove('3');
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());

		gameController.makeAMove('4');
		Assertions.assertEquals(first, gameController.getCurrentPlayer());
		Assertions.assertEquals(second, gameController.getNextPlayer());

		gameController.makeAMove('5');
		Assertions.assertEquals(first, gameController.getNextPlayer());
		Assertions.assertEquals(second, gameController.getCurrentPlayer());

		gameController.makeAMove('6');
		Assertions.assertEquals(first, gameController.getCurrentPlayer());
		Assertions.assertEquals(second, gameController.getNextPlayer());
	}
}
