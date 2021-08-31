package org.kishan.year_2021.month_august.date_31;

/**
 * 	Given an integer array nums sorted in ascending order (with distinct values), and an integer target
 *
 * 	if target is found in the arrau return its index, otherwise, return -1
 *
 * 	Input = [4,5,6,7,0,1,2] , target = 0
 * 	output = 4
 *
 * 	Input = [4,5,6,1,2,3] , target = 0
 * 	output = -1
 *
 */
public class SearchInRotatedArray {

	static int search(int[] nums,int target){
		int left = 0;
		int right = nums.length - 1;

		if(nums[left] == target){
			return left;
		}
		if(nums[right] == target){
			return right;
		}

		while(left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return mid;
			}
			if(nums[left] <= nums[mid]){
				if(target > nums[left] && target < nums[mid]){
					right = mid - 1;
				}
				else{
					left = mid;
				}
			}
			else{
				if(target > nums[mid] && target < nums[right]){
					left = mid + 1;
				}
				else{
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,1,2};
		int target = 0;
		System.out.println(target + " found in sorted array -> " + search(nums,target));
	}
}
