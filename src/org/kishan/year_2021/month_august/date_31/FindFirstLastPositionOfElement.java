package org.kishan.year_2021.month_august.date_31;

import java.util.Arrays;

public class FindFirstLastPositionOfElement {

	//Time : O(n), Space : O(1)
	static int[] searchRange(int[] nums, int target){
		int first = -1,last = -1;
		int i = 0, j = nums.length -1;

		while(i < j){
			if(first == -1 && nums[i] == target){
				first = i;
			}
			if(last == -1 && nums[j] == target){
				last = j;
			}

			if(first == -1){
				i++;
			}
			else if(last == -1) {
				j--;
			}else{
				break;
			}
		}
		return new int[] {first,last};
	}

	//Binary Search Approach
	// Time : O(logn), Space : O(1)
	 static int[] searchRangeBS(int[] nums,int target){
		int end = findEndIndex(nums,target);

		if(end == -1) return new int[] {-1,-1};

		int start = findStartIndex(nums,target);

		return new int[] {start,end};
	 }
	private static int findStartIndex(int[] nums, int target) {
		int left = 0, right = nums.length -1;

		while(left < right){
			int mid = (left + (right - left) / 2) + 1; //right most index

			if(nums[mid] == target){
				right = mid;
			}
			else if (nums[mid] < target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}

		return left;
	}
	private static int findEndIndex(int[] nums, int target) {
		int left = 0, right = nums.length -1;

		while(left < right){
			int mid = (left + (right - left) / 2) + 1; //right most index

			if(nums[mid] == target){
				left = mid;
			}
			else if (nums[mid] < target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}

		return (left >= nums.length || nums[left] != target) ? -1 : left;
	}
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println("First and Last Position of " + target + " -> " + Arrays.toString(searchRangeBS(nums, target)));
	}
}
