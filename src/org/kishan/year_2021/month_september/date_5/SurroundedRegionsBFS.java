package org.kishan.year_2021.month_september.date_5;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 	-- Time : O(r * c), where r,c is the number of rows and column
 * 	-- Space : O(r * c),for queue
 */
public class SurroundedRegionsBFS {
	private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

	static void solve(char[][] board){
		if(board.length == 0) return;

		markUnFlippable(board);
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c] == 'O'){
					board[r][c] = 'X';
				}
				if(board[r][c] == 'U'){
					board[r][c] = 'O';
				}
			}
		}
	}
	private static void markUnFlippable(char[][] board) {
		for(int r = 0; r < board.length - 1; r++) {
			markUnFlippable(r,0,board);
			markUnFlippable(r,board[r].length-1,board);
		}
		for(int c = 0; c < board[0].length - 1; c++) {
			markUnFlippable(0,c,board);
			markUnFlippable(board.length-1,c,board);
		}
	}
	private static void markUnFlippable(int r, int c, char[][] board) {
		if(board[r][c] != 'O') return;

		board[r][c] = 'U';
		Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(r,c));
		board[r][c] = 'U';
		while(!queue.isEmpty()){
			Pair<Integer, Integer> pair = queue.poll();
			r = pair.getKey(); c=pair.getValue();
			for(int[] d : DIRECTIONS){
			 	int nr = r + d[0], nc = c + d[1];

				 if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[nr].length || board[nr][nc] != 'O') continue;
				queue.add(new Pair<>(nr,nc));
				board[nr][nc] = 'U';
			}
		}

	}
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X','X'},
						  {'X','X','O','O','X'},
						  {'X','X','X','O','X'},
						  {'X','X','O','X','X'}};
		solve(board);
		System.out.println(Arrays.deepToString(board));
	}
}
