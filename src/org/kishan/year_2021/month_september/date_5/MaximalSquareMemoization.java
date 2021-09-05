package org.kishan.year_2021.month_september.date_5;

/**
 * 		-- Time : O( 2 * mn) = O(mn)
 * 		-- Space : O(mn) , memo matrix
 *
 */
public class MaximalSquareMemoization {

	static int maximalSquare(char[][] matrix){
		int maxLength = 0;
		int[][] memo = new int[matrix.length][matrix[0].length];
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[r].length; c++) {
				maxLength = Math.max(maxLength,miximalSquare(r,c,matrix,memo));
			}
		}
		return maxLength * maxLength;
	}
	private static int miximalSquare(int r, int c, char[][] matrix,int[][] memo) {
		if(r >= matrix.length || c >= matrix[r].length || matrix[r][c] != '1') return 0;
		if(memo[r][c] != 0) return memo[r][c];
		return memo[r][c] = Math.min(
				miximalSquare(r + 1,c,matrix,memo),
				Math.min(miximalSquare(r,c+1,matrix,memo), miximalSquare(r+1,c+1,matrix,memo))
		) + 1;
	}
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}};
		System.out.println("Maximal Square length -> " + maximalSquare(matrix));
	}
}
