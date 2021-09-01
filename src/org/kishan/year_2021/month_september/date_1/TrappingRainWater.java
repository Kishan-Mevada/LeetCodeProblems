package org.kishan.year_2021.month_september.date_1;

/**
 * 	given a non-negative integers representing an elevation map where width of each is 1,compute how much water it can trap after raining
 *
 * 	input = [0,1,0,2,1,0,1,3,2,1,2,1]  output = 6
 *
 * 	Solution Algorithm (2 pointer approach)
 *
 * 	- create following variables
 * 		- start, start index of input height, start = 0
 * 		- end, end index of input height, end = height.length - 1
 * 		- maxLeft, current tallest pillar on left side, maxLeft = 0
 * 		- maxRight, current tallest pillar on right side, maxRight = 0
 * 		- water , total trapped water, water = 0
 *
 * 	- iterate till start <= end
 * 		- if height[start] < height[end]
 * 			- if maxLeft < height[start]
 * 				- update maxLeft to height[start]
 * 				- increment start index
 * 			- else
 * 				- increment water by maxLeft - height[start]
 * 				- increment start index
 * 	   - else
 * 	   		- if maxRight < height[end]
 * 	   			- set maxRight = height[end]
 * 	   			- decrement end
 * 	   		- else
 * 	   			- update water by maxRight - height[end]
 * 	   			- decrement end
 *
 * 	- return water
 *
 * 	Time : O(n)
 * 	Space : (1)
 *
 *
 */
public class TrappingRainWater {

	static int trap(int[] height){
		int start = 0, end = height.length - 1,water = 0, maxLeft = 0,maxRight = 0;
		while(start <= end){
			if(height[start] < height[end]){ // trap from start if height is smaller than end index
				if(maxLeft < height[start]){ // if left the tallest pillar is less than current height then we cant trap any water
					maxLeft = height[start++];
				}
				else{
					water += maxLeft - height[start++];
				}
			}
			else{
				if(maxRight < height[end]){
					maxRight = height[end--];
				}
				else{
					water += maxRight - height[end--];
				}
			}
		}
		return water;
	}
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Trapping rain water -> " + trap(height));
	}
}
