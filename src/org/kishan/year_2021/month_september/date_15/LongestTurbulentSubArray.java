package org.kishan.year_2021.month_september.date_15;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 *
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
 *
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 */
public class LongestTurbulentSubArray {

	static int maxTurbulenceSize(int[] arr) {
		int i = 0,j = 1, maxLen = 1;
		long lastDiff = 0;
		while(j < arr.length){
			int currDiff = arr[j] - arr[j-1];
			if(currDiff * lastDiff > 0){
				i = j - 1;
			}
			else if(arr[j] == arr[j-1]){
				i = j;
			}
			maxLen = Math.max(maxLen,j-i+1);
			lastDiff = currDiff;
			j++;
		}
		return maxLen;
	}
	public static void main(String[] args) {
		int[] arr = {9,4,2,10,7,8,8,1,9};
		System.out.println("Longest Turbulent Sub array -> " + maxTurbulenceSize(arr));
	}
}
