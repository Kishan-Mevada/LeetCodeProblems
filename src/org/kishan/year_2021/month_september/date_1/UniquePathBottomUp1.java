package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Bottom UP)
 *
 *	- create array to keep track of number of ways, denoted as ways[][]
 *	- Iterate from 1 -> m, denoted as i
 *	  -	Iterate from 1 -> n, denoted as j
 *			- if i and j is equals  to 1
 *				- ways[j] = 1
 *				- continue
 *			- set ways[j] = ways[j-1] + ways[j]
 *	- return ways[n]
 *
 * 	-- Time : O(mn)
 * 	-- Space : O(n), where n is number of column
 */
public class UniquePathBottomUp1 {

	static int uniquePath(int m,int n){
		int[] ways = new int[n+1];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if( i == 1 && j == 1){
					ways[j] = 1;
					continue;
				}
				ways[j] = ways[j-1] + ways[j];
			}
		}
		return ways[n];
	}
	public static void main(String[] args) {
		int row = 3;
		int col = 7;
		System.out.println("Unique path -> " + uniquePath(row,col));
	}
}
