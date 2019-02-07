package com.bradburzon.controller;
import org.junit.jupiter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bradburzon.model.GameModel;


public class GameControllerTest {

	GameController gameController;
	
	
	/**
	 *  Test to make sure to get the right X, testing the extremes
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
	 *  Test to make sure to get the right X, testing the e
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

}
