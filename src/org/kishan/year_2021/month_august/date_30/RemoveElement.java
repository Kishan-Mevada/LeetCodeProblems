package org.kishan.year_2021.month_august.date_30;

/**
 *  Time : O(n)
 *  Space : O(1)
 */
public class RemoveElement {

	static int removeElement(int[] nums,int val){
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != val){
				nums[i++] = nums[j];
			}
		}
 		return i;
	}
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println("After removing " + val + " array length is " + removeElement(nums,val));
	}
}
