package org.kishan.year_2021.month_august.date_31;

/**
 *  Given sorted array of distinct integers and target value
 *  return the index if target found,if not, return the index it would be if it were inserted in order.
 *
 *  input			target			output
 * [1,3,5,6]		5				2
 * [1,3,5,6]		2				1
 * [1,3,5,6]		7				4
 * [1,3,5,6]		0				0
 *
 */
public class SearchInsertPosition {

	static int searchInsert(int[] nums,int target){
		int left = 0;
		int right = nums.length - 1;

		while(left < right){
			int mid = left + (right - left) / 2;

			if(nums[mid] == target){
				return mid;
			}
			else if(nums[mid] < target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}

		return nums[right] < target ? right + 1 : right;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6};
		int target = 0;
		System.out.println("Search insert position -> " + searchInsert(nums,target));
	}
}
