package org.kishan.year_2021.month_august.date_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Time : O(n^3), where n is length of array
 *  Space : O(q), where q is resulting list
 */
public class FourSum {

	static List<List<Integer>> fourSum(int[] arr,int target){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-3; i++) {
			if( i != 0 && arr[i] == arr[i-1]) continue;
			for(int j = i+1; j < arr.length-2; j++) {
				if(j != i + 1 && arr[j] == arr[j-1]) continue;

				int k = j + 1, m = arr.length - 1;

				while(k < m){
					if(k != j + 1 && arr[k] == arr[k-1]){
						k++;
						continue;
					}
					if(m != arr.length - 1 && arr[m] == arr[m+1]){
						m--;
						continue;
					}

					int sum = arr[i] + arr[j] + arr[k] + arr[m];

					if(sum == target){
						result.add(Arrays.asList(arr[i],arr[j],arr[k],arr[m]));
						k++;
					}
					else if( sum < target){
						k++;
					}
					else{
						m--;
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println("four sum -> " + fourSum(arr,target));
	}
}
