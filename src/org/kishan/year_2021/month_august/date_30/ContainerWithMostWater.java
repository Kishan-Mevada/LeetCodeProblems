package org.kishan.year_2021.month_august.date_30;

/**
 * 	find the area of container which holds the max water
 *
 *
 * 	Solution Algorithm
 *
 * 	- create the below variables
 * 	- start , start index of array as 0
 * 	- end , end index of array as array.length
 * 	- maxArea, to store max area
 *
 * 	- iterate array till start < end
 * 		- get min value from both index and multiply by width (start - end) and store in arad
 * 			- area = min(arr[start],arr[end]) * ( end - start)
 * 		- update maxArea if area is greater than current maxArea
 * 		- if arr[start] < arr[end]
 * 			- increment start
 * 		- else
 * 			- decrement end
 *
 * 	return maxArea;
 *
 * Time : O(n)
 * Space : O(1)
 */
public class ContainerWithMostWater {

	static int maxArea(int[] height){
		int start = 0, end = height.length - 1, maxArea = 0;

		while(start < end){
			int area = Math.min(height[start],height[end]) * (end - start);
			maxArea = Math.max(maxArea,area);

			if(height[start] < height[end]){
				start++;
			}
			else{
				end--;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println("Max Area -> " + maxArea(height));
	}
}
