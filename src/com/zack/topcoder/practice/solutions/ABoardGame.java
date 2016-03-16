package com.zack.topcoder.practice.solutions;

/**
 * Class Description
 * Created on   3/14/2016
 *
 * @author Zack Yao
 */
public class ABoardGame {
	public static final String INVALID_BOARD = "Invalid Board";
	public static final String ALICE_WINS = "Alice";
	public static final String BOB_WINS = "Bob";
	public static final String DRAW = "Draw";

	public String whoWins(String[] board) {

		// Check for invalid input
		if (board == null) {
			return INVALID_BOARD;
		}

		if (board.length < 2 || board.length % 2 != 0) {
			return INVALID_BOARD;
		}

		int boardLength = board.length;
		int halfwayPointY = boardLength / 2;

		// Initialize Bob and Alice's scoreboard that we'll use later
		// Points can be worth up to length/2 value
		int[] aliceScoreBoard = new int[halfwayPointY];
		int[] bobScoreBoard = new int[halfwayPointY];

		// Initialize the value of the row to be zero
		int rowValue = 0;
		for (int boardRow = 0; boardRow < boardLength; boardRow++) {
			// Find the length of the particular string and make sure it's the same length as the array
			int boardWidth = board[boardRow].length();
			int halfwayPointX = board[boardRow].length() / 2;
			if (boardLength != boardWidth) {
				return INVALID_BOARD;
			}

			// If the row we're on is greater than half of the Array Length, then we need to decrement the value of it
			if (boardRow > halfwayPointY) {
				rowValue--;
			}

			// Get the string associated with the row
			String row = board[boardRow];

			// Initialize Column value to be zero
			int columnValue = 0;
			for (int boardColumn = 0; boardColumn < board[boardRow].length(); boardColumn++) {
				// Get the first char of the String at row "boardRow"
				char column = row.charAt(boardColumn);

				// If the column index is greater than half of the String length, we'll decrement it
				// e.g. if boardColumn = 3 and halfwayPointX = 2 (row length of 4) then we'll want to decrement our
				// column value to reflect the correct position according to the board.
				if (boardColumn > halfwayPointX) {
					columnValue--;
				}

				// Check what value we actually found.
				switch (column) {
					case 'A':
						// Alice point based off of column and row
						// Get the lowest value of either column or row and use that
						int totalValueAlice = (rowValue <= columnValue) ? rowValue : columnValue;
						aliceScoreBoard[totalValueAlice] += 1;
						break;
					case 'B':
						// Bob point based off of column and row
						// Get the lowest value of either column or row and use that
						int totalValueBob = (rowValue <= columnValue) ? rowValue : columnValue;
						bobScoreBoard[totalValueBob] += 1;
						break;
					case '.':
						break;
				}
				// Increment column value if we haven't reached the halfway point yet
				if (boardColumn < halfwayPointX - 1) {
					columnValue++;
				}
			}
			// Increment row value if we haven't reached the halfway point yet
			if (boardRow < halfwayPointY - 1) {
				rowValue++;
			}
		}

		// Iterate through the scoreboards from the end (highest) to find a tie breaker as quick as possible
		for (int bestPointValue = halfwayPointY - 1; bestPointValue >= 0; bestPointValue--) {
			if (aliceScoreBoard[bestPointValue] == bobScoreBoard[bestPointValue]) {
				continue;
			} else if (aliceScoreBoard[bestPointValue] > bobScoreBoard[bestPointValue]) {
				return ALICE_WINS;
			} else {
				return BOB_WINS;
			}
		}
		return DRAW;
	}
}
