package org.kishan.year_2021.month_september.date_3;

/**
 * 	given an m * n board and a word,find if word is exists in the grid
 *
 * 	 Solution Algorithm (backtracking approach)
 *
 *  - Iterate through the rows and columns of board
 * 	 - create following variables
 * 	 	- r, current row
 * 	 	- c, current column
 * 	 	- i, current index inside word
 * 	 	- board, input board
 * 	 	- word, input word
 * 	 - base condition
 * 	 	- if r is out of bound
 * 	 		- return true
 * 	 	- if r,c out of bound or current character inside board[r][c] is not equal to character at index i inside word
 * 	 		- return false
 * 	 - each recursive call
 * 	 	- create variable ch and set it to board[r][c]
 * 	 	- set board[r][c] to #
 * 	 	- Iterate through the 4 directions, denoted as d
 * 	 		- recursively find the rest of the character
 * 	 			- r = r + d[0]
 * 	 			- c = c + d[1]
 * 	 			- i = i + 1
 * 	 		- if the recursive call is true
 * 	 			- return true
 * 	 		- set board[r][c] to ch
 * 	 		- return false
 * 	 - if recursive call is true
 * 	 	- return true
 * 	 - return false
 *
 * 	 -- Time : O(n * 3^k), where n is total nunmber of cells and k is length of the word
 * 	 -- Space : O(k)
 *
 * 	-
 */
public class WordSearch {
	private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	static boolean isExist(char[][] board,String word){
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(isExist(r,c,0,board,word)) return true;
			}
		}
		return false;
	}
	private static boolean isExist(int r, int c, int i, char[][] board, String word) {
		if(i >= word.length()) return true;
		if(r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] != word.charAt(i)) return false;

		char ch = board[r][c];
		board[r][c] = '$';
		for(int[] d : DIRECTIONS){
			if(isExist(r + d[0],c+d[1],i+1,board,word)) return true;
		}
		board[r][c] = ch;
		return false;
	}
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println("Is Word " + word + " exists -> " + isExist(board,word));
	}
}
