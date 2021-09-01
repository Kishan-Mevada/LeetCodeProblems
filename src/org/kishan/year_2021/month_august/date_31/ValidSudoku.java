package org.kishan.year_2021.month_august.date_31;

import java.util.HashSet;
import java.util.Set;

/**
 * 	Time : O(mn), where m,n are number of rows and columns
 * 	Space : O(mn)
 */
public class ValidSudoku {

	static boolean isValidSudoku(char[][] board){
		Set<String> seen = new HashSet<>();
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == '.') continue;

				if(!seen.add(stringfy("row",row,board[row][col])) ||
					!seen.add(stringfy("col",row,board[row][col])) ||
						!seen.add(stringfy("box",row/3,col/3,board[row][col]))){
					return false;
				}
			}
		}
		return true;
	}
	private static String stringfy(String box, int row, int col, char val) {
		return new StringBuilder(box)
				.append("-")
				.append(row)
				.append("-")
				.append(col)
				.append("#")
				.append(val).toString();
	}
	private static String stringfy(String direction, int row, char val) {
		return new StringBuilder(direction)
				.append("-")
				.append(row)
				.append("#")
				.append(val).toString();
	}
	public static void main(String[] args) {
		char[][] board ={
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(isValidSudoku(board));
	}
}
