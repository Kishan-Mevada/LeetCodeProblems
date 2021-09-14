package org.kishan.year_2021.month_september.date_14;

/**
 * 	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 */
public class MaxAreaWater {

	public int maxArea(int[] height) {
		int start = 0,end = height.length-1, maxArea = 0;

		while(start < end){
			maxArea = Math.max(maxArea, Math.min(height[start],height[end]) * (end - start));

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

	}
}
