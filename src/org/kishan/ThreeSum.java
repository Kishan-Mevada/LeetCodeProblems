package org.kishan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * input : [-1,0,1,2,-1,-4]
 *
 * output : [-1,-1,2],[-1,0,1]
 *
 * Time : O(log n) + O(n^2) = O(n^2), where n is length of array
 * Space : O(t) , where t is number of triplets
 * 		 
 */
public class ThreeSum {

	static List<List<Integer>> threeSum(int[] arr){
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);// O(log n)
		for(int i = 0; i < arr.length; i++) {  // O(n^2)
			if(i != 0 && arr[i] == arr[i-1]) continue;

			int j = i + 1,k = arr.length - 1;

			while(j < k){
				if(j != i + 1 && arr[j] == arr[j-1]){
					j++;
					continue;
				}

				if(k != arr.length - 1 && arr[k] == arr[k+1]){
					k--;
					continue;
				}

				int sum = arr[i] + arr[j] + arr[k];

				if(sum == 0){
					triplets.add(Arrays.asList(arr[i],arr[j++],arr[k]));
				}
				else if (sum < 0){
					j++;
				}
				else{
					k--;
				}
			}
		}
		return triplets;
	}
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		System.out.println("3 sum -> " + threeSum(arr));
	}
}
