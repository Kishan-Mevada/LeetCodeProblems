package org.kishan.year_2021.month_september.date_3;

/**
 * 	write an efficient algorithm that searches for a value in an m * n matrix. matrix has the following properties
 *
 * 		- Integers are in each row are sorted from left to right
 * 		- the first integer is greater than last integer of previous row
 *
 * 	Input :
 * 	[	1,3,5,7
 * 		10,11,16,20,
 * 		23,30,34,60
 * 	]
 * 	target = 3
 * 	output = true
 *
 * 	Solution Algorithm
 *
 * 	- create following variables
 * 		- i , current row, start from 0
 * 		- j,  last column, start from last
 * 	- while r and c is not out bound
 * 		- if matrix[i][j] == target
 * 			- return true
 * 		- if matrix[i][j] is smaller than target
 * 			- i -> i + 1
 * 		- if matrix[i][j] is greater than target
 * 			- j -> j + 1
 *
 * 	- return false
 *
 * 		-- Time : O(m+n), where m and n are the number of column
 * 		-- Space : O(1)
 */
public class Search2DMatrix {

	static boolean search(int[][] matrix,int target){
		int i = 0;
		int j = matrix[i].length - 1;

		while(i < matrix.length  && j >= 0){
			if(matrix[i][j] == target){
				return true;
			}
			if(matrix[i][j] < target){
				i++;
			}
			else{
				j--;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 30;
		System.out.println("Is " + target + " Exist in matrix -> " + search(matrix,target) );
		target = 110;
		System.out.println("Is " + target + " Exist in matrix -> " + search(matrix,target) );
	}
}
