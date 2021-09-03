package org.kishan.year_2021.month_september.date_3;

/**
 * 	input = [1,1,1,2,2,3]
 * 	output = [1,1,2,2,3]
 *
 * 	 duplicate number should appear most twice
 * 	  return the length
 *
 * 	  solution must be in constants space
 *
 * 	  -- Time : O(n)
 * 	  -- Space : O(1)
 *
 */
public class RemoveDuplicateFromSortedArray1 {

	static int removeDuplicate(int[] nums){
		int i = 0, count = 0;//
		for(int j = 0; j < nums.length; j++) {
			count++;
			if(count <= 2){
				nums[i++] = nums[j];
			}
			// j is at last index or current and next element is not same then reset count
			if(j == nums.length - 1 || nums[j] != nums[j+1]){
				count = 0;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int i = removeDuplicate(nums);
		for(int j = 0; j < i; j++) {
			System.out.print(nums[j] + " ");
		}
	}
}
