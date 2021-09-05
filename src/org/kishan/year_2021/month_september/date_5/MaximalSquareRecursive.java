package org.kishan.year_2021.month_september.date_5;

/**
 * 		-- Time : O( (mn) * (3^(m+n))
 * 		-- Space : O(m + n) , recursive call
 *
 */
public class MaximalSquareRecursive {

	static int maximalSquare(char[][] matrix){
		int maxLength = 0;
		for(int r = 0; r < matrix.length; r++) {
			for(int c = 0; c < matrix[r].length; c++) {
				maxLength = Math.max(maxLength,miximalSquare(r,c,matrix));
			}
		}
		return maxLength * maxLength;
	}
	private static int miximalSquare(int r, int c, char[][] matrix) {
		if(r >= matrix.length || c >= matrix[r].length || matrix[r][c] != '1') return 0;

		return Math.min(
				miximalSquare(r + 1,c,matrix),
				Math.min(miximalSquare(r,c+1,matrix), miximalSquare(r+1,c+1,matrix))
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
