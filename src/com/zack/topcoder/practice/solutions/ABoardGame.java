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
//		Map<Integer, Integer> aliceScoreBoard = new HashMap<>();
//		Map<Integer, Integer> bobScoreBoard = new HashMap<>();
		if (board == null) {
			return INVALID_BOARD;
		}

		if (board.length < 2 || board.length % 2 != 0) {
			return INVALID_BOARD;
		}

		int boardLength = board.length;
		int halfwayPointY = boardLength / 2;

		int[] aliceScoreBoard = new int[halfwayPointY + 1];
		int[] bobScoreBoard = new int[halfwayPointY + 1];
		int rowValue = 0;
		for (int boardRow = 0; boardRow < boardLength; boardRow++) {
			int boardWidth = board[boardRow].length();
			int halfwayPointX = board[boardRow].length() / 2;
			if (boardLength != boardWidth) {
				return INVALID_BOARD;
			}
			String row = board[boardRow];
			int columnValue = 1;
			for (int boardColumn = 0; boardColumn < board[boardRow].length(); boardColumn++) {
				char column = row.charAt(boardColumn);

				switch (column) {
					case 'A':
						//Alice point based off of column and row
						int totalValueAlice = (rowValue <= columnValue) ? rowValue : columnValue;
//						aliceScoreBoard.put(totalValueAlice, aliceScoreBoard.get(totalValueAlice) == null ? 0 : aliceScoreBoard.get(totalValueAlice) + 1);
						aliceScoreBoard[totalValueAlice] += 1;
						break;
					case 'B':
						int totalValueBob = (rowValue <= columnValue) ? rowValue : columnValue;
//						bobScoreBoard.put(totalValueBob, bobScoreBoard.get(totalValueBob) == null ? 0 : bobScoreBoard.get(totalValueBob) + 1);
						//Bob point based off of column and row
						bobScoreBoard[totalValueBob] += 1;
						break;
					case '.':
						break;
				}
				// Increment or decrement point value of the column value depending on where it is
				if (boardColumn < halfwayPointX) {
					columnValue++;
				} else if (boardColumn > halfwayPointX) {
					columnValue--;
				}
			}
			// Increment or decrement point value of the row depending on where it is
			if (boardRow < halfwayPointY) {
				rowValue++;
			} else if (boardRow > halfwayPointY) {
				rowValue--;
			}
		}
		for (int bestPointValue = halfwayPointY - 1; bestPointValue >= 0; bestPointValue++) {
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
