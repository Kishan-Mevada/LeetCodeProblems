package org.kishan.year_2021.month_august.date_30;

/**
 *	Time : O(n)
 *  Space : O(1)
 */
public class RemoveDuplicatesFromSortedArray {

	static int removeDuplicates(int[] nums){
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			 nums[i++] = nums[j];

			 while(j != nums.length - 1 && nums[j+1] == nums[j]){
				 j++;
			 }
		}
		return i;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println("After removing duplicate array length is -> " + removeDuplicates(nums));
	}
}
