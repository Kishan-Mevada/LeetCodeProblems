package org.kishan.year_2021.month_september.date_20;

import java.util.Arrays;

/**
 *
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 *
 * Here are the rules of Tic-Tac-Toe:
 *
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.
 *
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 *
 */
public class TicTakToeWinner {

	static String tictactoe(int[][] moves) {
		String[][] board = new String[3][3];

		boolean isOdd = true;
		for(int[] mv : moves){
			if(isOdd){
				board[mv[0]][mv[1]] = "X";
			}
			else{
				board[mv[0]][mv[1]] = "O";
			}
			isOdd = !isOdd;
		}

		for(int i = 0; i < 8; i++){
			String line = "";
			switch(i){
				case 0:
					line = board[0][0] + board[0][1] + board[0][2];
					break;
				case 1:
					line = board[1][0] + board[1][1] + board[1][2];
					break;
				case 2:
					line = board[2][0] + board[2][1] + board[2][2];
					break;
				case 3:
					line = board[0][0] + board[1][0] + board[2][0];
					break;
				case 4:
					line = board[0][1] + board[1][1] + board[2][1];
					break;
				case 5:
					line = board[0][2] + board[1][2] + board[2][2];
					break;
				case 6:
					line = board[0][0] + board[1][1] + board[2][2];
					break;
				case 7:
					line = board[0][2] + board[1][1] + board[2][0];
					break;
			}

			if("XXX".equals(line)) return "A";
			if("OOO".equals(line)) return "B";
		}

		return moves.length == 9 ?  "Draw" : "Pending";
	}

	static String tictactoe1(int[][] moves) {
		int n = 3;
		int[] rows = new int[n];
		int[] cols = new int[n];
		int diag = 0, anti_diag =0;

		int player = 1;

		for(int[] mv : moves){
			int r = mv[0], c = mv[1];
			rows[r] += player;
			cols[c] += player;

			if(r == c){
				diag += player;
			}

			if(r + c == n - 1)
			{
				anti_diag += player;
			}

			if(Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n){
				return player == 1 ? "A" : "B";
			}

			player *= -1;
		}

		return moves.length == n*n ?  "Draw" : "Pending";
	}

	public static void main(String[] args) {
		int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
		System.out.println("Winner is -> " + tictactoe1(moves));
	}
}
