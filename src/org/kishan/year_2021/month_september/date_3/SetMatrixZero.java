package org.kishan.year_2021.month_september.date_3;

import java.util.Arrays;

/**
 * 		Time : O(2 * mn)
 * 		Space : O(1)
 */
public class SetMatrixZero {

	static void setZero(int[][] matrix){
		boolean rowHasZero = false,colHasZero = false;
		for(int c = 0; c < matrix[0].length;c++){
			if(matrix[0][c] == 0){
				rowHasZero = true;
				break;
			}
		}
		for(int r = 0; r < matrix[0].length;r++){
			if(matrix[r][0] == 0){
				colHasZero = true;
				break;
			}
		}
		for(int r = 1; r < matrix.length; r++) {
			for(int c = 1; c < matrix[r].length; c++) {
				if(matrix[r][c] == 0){
					matrix[r][0] = 0;
					matrix[0][c] = 0;
				}
			}
		}

		fillMatrix(matrix,rowHasZero,colHasZero);
	}
	private static void fillMatrix(int[][] matrix, boolean rowHasZero, boolean colHasZero) {
		for(int c = 1; c < matrix[0].length; c++) {
			if(matrix[0][c] == 0) fillColumn(matrix,c);
		}

		for(int r = 1; r < matrix.length; r++) {
			if(matrix[r][0] == 0) fillRow(matrix,r);
		}

		if(rowHasZero) fillRow(matrix,0);
		if(colHasZero) fillColumn(matrix,0);
	}
	private static void fillRow(int[][] matrix, int r) {
		for(int c = 1; c < matrix.length; c++) {
			matrix[r][c] = 0;
		}
	}
	private static void fillColumn(int[][] matrix, int c) {
		for(int r = 1; r < matrix.length; r++) {
				matrix[r][c] = 0;
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println("Matrix before filling zeros -> " + Arrays.deepToString(matrix));
		setZero(matrix);
		System.out.println("Matrix after filling zeros (setZero) -> " + Arrays.deepToString(matrix));
	}
}
