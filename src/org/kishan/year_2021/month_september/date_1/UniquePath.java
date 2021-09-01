package org.kishan.year_2021.month_september.date_1;

import java.sql.SQLOutput;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Recursive)
 *
 *  - base case
 *  	- if m and n is 1
 *  		return 1
 *      - if m or n is 0
 *      	return 0
 *  - in each recursive call
 *  	- recursively find the number of path1 if we move leftward -> n = n - 1
 *  	- recursively find the number of path2 if we move upward -> m = m - 1
 *  	- return path1 + path2
 *
 *   -- Time : (2^(m+n)), where m and n are input, each recursive call we have 2 choices
 *   -- Space : O(m+n), recursive call
 *
 *   Note : this approach may lead to time limit exceeded
 */
public class UniquePath {

	static int uniquePath(int m,int n){
		if(m == 1 && n == 1) return 1;
		if(m == 0 || n == 0) return 0;

		return uniquePath(m-1,n) + uniquePath(m,n-1);
	}
	public static void main(String[] args) {
		int row = 3;
		int col = 7;
		System.out.println("Unique path -> " + uniquePath(row,col));
	}
}
