package org.kishan.year_2021.month_september.date_16;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
	static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int i, row = 0, col = 0;
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		while(row < rowLen && col < colLen) {
			for(i = col; i < colLen; i++) {
				result.add(matrix[row][i]);
			}
			row++;
			for(i = row; i < rowLen; i++) {
				result.add(matrix[i][colLen - 1]);
			}
			colLen--;
			if(row < rowLen) {
				for(i = colLen - 1; i >= col; i--) {
					result.add(matrix[rowLen - 1][i]);
				}
				rowLen--;
			}
			if(col < colLen) {
				for(i = rowLen - 1; i >= row; i--) {
					result.add(matrix[i][col]);
				}
				col++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix));
	}
}
