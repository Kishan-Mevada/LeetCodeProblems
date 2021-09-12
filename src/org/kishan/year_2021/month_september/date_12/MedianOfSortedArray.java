package org.kishan.year_2021.month_september.date_12;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 */
public class MedianOfSortedArray {

	static double median(int[] nums1,int[] nums2){
		int[] num3 = new int[nums1.length + nums2.length];

		int i = 0;
		int j = 0;

		while(i < nums1.length || j < nums2.length){
			if(i == nums1.length){
				num3[i+j] = nums2[j];
				j++;
			}
			else if(j == nums2.length){
				num3[i+j] = nums1[j];
				i++;
			}
			else {
				if(nums1[i] < nums2[j]){
					num3[i+j] = nums1[i];
					i++;
				}
				else{
					num3[i+j] = nums2[j];
					j++;
				}
			}
		}
		int mid = num3.length / 2;
		if(num3.length % 2 == 0){
			return (double)(num3[mid-1] + num3[mid]) / 2;
		}
		else{
			return num3[mid];
		}
	}

	static double medianConstantSpace(int[] nums1,int[] nums2){
		int mid = (nums1.length + nums2.length) / 2;
		boolean isEvan = (nums1.length + nums2.length) % 2 == 0;
		int i = 0,j = 0,sum = 0;
		while(i < nums1.length || j < nums2.length){
			int index = i + j;
			int num = 0;
			if(i == nums1.length) {
				num = nums2[j++];
			}
			else if(j == nums2.length) {
				num = nums1[i++];
			}
			else if(nums1[i] < nums2[j]){
				num = nums1[i++];
			}
			else{
				num = nums2[j++];
			}

			if(isEvan && (mid-1 == index)){
				sum += num;
			}
			if(mid == index){
				sum += num;
				break;
			}
		}

		return isEvan ? (double)sum / 2 : sum;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println("Median -> " + median(nums1,nums2));
		System.out.println("Median Constant space-> " + medianConstantSpace(nums1,nums2));
	}
}
