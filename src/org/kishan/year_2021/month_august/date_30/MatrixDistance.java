package org.kishan.year_2021.month_august.date_30;

import java.util.Arrays;

/**
 * 	Given a matrix consists of 0 and 1,find the distance of the nearest 0 for each cell
 * 	The distance between 2 adjacent cells is 1
 *
 * 	Note
 * 	- The number of elements of given matrix will not exceed 10,000
 * 	- The cells are adjacent in only four directions up,down,left and right
 *
 * 	example 			output
 * 	[[0,0,0],			[[0,0,0],
 * 	 [0,1,0],			 [0,1,0],
 * 	 [0,0,0]]			 [0,0,0]]
 *
 * 	[[0,0,0],			[[0,0,0],
 * 	 [0,1,0],			 [0,1,0],
 * 	 [1,1,1]]			 [1,2,1]]
 *
 * 	 Solution Algorithm
 *
 * 	 - create a distance matrix which keep distance to nearest 0
 * 	 - find the distance top left to bottom right
 * 	 		- Iterate from top left to bottom right, denoted as 'r,c'
 * 	 			- if matrix[r][c] == 0
 * 	 				- set distance[r][c] = 0
 * 	 				- continue to next iteration
 * 	 			- if r > 0, find the minimum distance to 0 from cell above up
 * 	 				- update distance[r][c] if distance[r-1][c] + 1 smaller
 * 	 			- if c > 0, find the minimum distance to 0 from cell to the left
 * 	 				- update distance[r][c] if distance[r][c-1] + 1 smaller
 * 	 - find the distance bottom right to top left
 			 - Iterate from top left to bottom right, denoted as 'r,c'
 * 	 			- if r != last row, find the minimum distance to 0 from cell above below
 * 	 				- update distance[r][c] if distance[r+1][c] + 1 smaller
 * 	 			- if c != last column, find the minimum distance to 0 from cell to the right
 * 	 				- update distance[r][c] if distance[r][c+1] + 1 smaller		-
 * 	 - return distance
 *
 * 	 Time :  (3 * n) = O(n)
 * 	 Space : O(n)
 */

public class MatrixDistance {
	private static final int MAX_VALUE = 10000;
	public static int[][] findDistance(int[][] matrix){
		int m = matrix.length,n = matrix[0].length;
		int[][] distance = new int[m][n];

		//fill distance matrix with max number
		for(int r = 0;r < m;r++){
			Arrays.fill(distance[r], MAX_VALUE);
		}


		for(int r = 0;r < m;r++){
			for(int c = 0;c < n;c++){
				if(matrix[r][c] == 0){
					distance[r][c] = 0;
					continue;
				}

				if(r > 0) distance[r][c] = Math.min(distance[r][c],distance[r-1][c]+1);
				if(c > 0) distance[r][c] = Math.min(distance[r][c],distance[r][c-1]+1);
			}
		}

		for(int r = m-1;r >= 0;r--){
			for(int c = n-1;c >= 0;c--){
				if(r != m - 1) distance[r][c] = Math.min(distance[r][c],distance[r+1][c]+1);
				if(c != n - 1) distance[r][c] = Math.min(distance[r][c],distance[r][c+1]+1);
			}
		}
		return distance;
	}
	public static void main(String[] args) {
		int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("Find distance of each cell from 0 -> ");
		System.out.println(Arrays.deepToString(findDistance(matrix)));
	}
}
