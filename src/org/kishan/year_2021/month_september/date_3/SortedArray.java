package org.kishan.year_2021.month_september.date_3;

import java.util.Arrays;

/**
 * 	Given two sorted integer arrays, num1 and num2, merge num2 into num1
 *
 * 	Input
 * 	num1 = [1,2,3,0,0,0]
 * 	num2 = [2,5,6]
 *
 *  Output = [1,2,2,3,5,6]
 *
 * 	-- Time : O(m + n)
 * 	-- Space : O(1)
 *
 */
public class SortedArray {

	static void merge(int[] num1,int m,int[] num2,int n){
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while(k >= 0){
			if(j >= 0 && num2[j] > num1[i]){
				num1[k--] = num2[j--];
			}
			else{
				num1[k--] = num1[i--];
			}
		}
	}
	public static void main(String[] args) {
		int[] num1 = {1,2,3,0,0,0};
		int[] num2 = {2,5,6};
		int m = 3,n = 3;
		merge(num1,m,num2,n);
		System.out.println(Arrays.toString(num1));
	}
}
