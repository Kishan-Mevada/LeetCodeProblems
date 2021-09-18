package org.kishan.year_2021.month_september.date_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {
	static int[] intersect(int[] nums1, int[] nums2) {
		int i = 0, j = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> result = new ArrayList<>();

		while(i < nums1.length && j < nums2.length){
			if(nums1[i] == nums2[j]){
				result.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i] < nums2[j]){
				i++;
			}
			else{
				j++;
			}
		}

		int[] arr = new int[result.size()];
		for(int k = 0; k < arr.length; k++) {
			arr[k] = result.get(k);
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
}
