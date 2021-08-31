package org.kishan.year_2021.month_august.date_31;

import java.util.Arrays;

/**
 *  3 closet sum
 *
 *  Time : O(n ^ 2), where n is length of array
 *  space : O(1)
 */
public class ThreeClosetSum {

	static int threeSum(int[] arr,int target){
		int minDiff = Integer.MAX_VALUE, result = -1;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length - 2; i++) {
			if (i != 0 && arr[i] == arr[i-1]) continue;

			int j = i + 1, k = arr.length - 1;

			while(j < k){
				int sum = arr[i] + arr[j] + arr[k];
				int diff = Math.abs(target - sum);

				if(diff < minDiff){
					minDiff = diff;
					result = sum;
				}
				if (sum < 0){
					j++;
				}
				else{
					k--;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {-1,2,1,-4};
		int target = 2;
		System.out.println("3 close sum -> " + threeSum(arr,target));
	}
}
