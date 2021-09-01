package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Recursive with Memoization)
 *
 *	- create memo[m][n]
 *  - base case
 *  	- if m and n is 1
 *  		return 1
 *      - if m or n is 0
 *      	return 0
 *     - if memo[m][n] != 0
 *     		return memo[m][n]
 *  - in each recursive call
 *  	- recursively find the number of path1 if we move leftward -> n = n - 1
 *  	- recursively find the number of path2 if we move upward -> m = m - 1
 *  	- return memo[m][n] = path1 + path2
 *
 *   -- Time : (m*n), where m and n are input, each recursive call we have 2 choices
 *   -- Space : O(m*n), recursive call + memoization
 *
 */
public class UniquePathMomoization {

	static int uniquePath(int m,int n){
		int[][] memo = new int[m+1][n+1];
		return uniquePath(m,n,memo);
	}

	static int uniquePath(int m,int n,int[][] memo){
		if(m == 1 && n == 1) return 1;
		if(m == 0 || n == 0) return 0;
		if(memo[m][n] != 0) return memo[m][n];
		return  memo[m][n] = uniquePath(m-1,n,memo) + uniquePath(m,n-1,memo);
	}
	public static void main(String[] args) {
		int row = 3;
		int col = 7;
		System.out.println("Unique path -> " + uniquePath(row,col));
	}
}
