package org.kishan.year_2021.month_august.date_30;

/**
 *  Given a string represented by several bits. Return whether the last character must be a one-bit chacter or not
 *
 *  Example
 *
 *  input = [1,0,0], output = true    10
 *  input = [1,1,1,0] , output : false 11,10
 *
 *  - Iterate each of the bit (variable b) at index 0 (variable i)
 *  	- if b == 1
 *  		- Increment i + 2
 *  	- else if b == 0
 *  		- Increment i + 1
 *
 *  - if index (variable i) is at the end of array
 *  	- then it must be 1 bit (0)
 *
 *   Time : O(n) , where n is length of array
 *   Space : O(1)
 */
public class OneBitCharacter {

	static boolean isOneBitCharacter(int[] bits){
		int i = 0;
		while(i < bits.length-1){
			if (bits[i] == 1)
			{
				i = i + 2;
			}
			else if (bits[i] == 0){
				i = i + 1;
			}
		}

		return i == bits.length - 1;
	}
	public static void main(String[] args) {
		System.out.println("Is One Bit Character -> " + isOneBitCharacter(new int[]{1, 0, 0}));
		System.out.println("Is One Bit Character -> " + isOneBitCharacter(new int[]{1, 1, 1, 0}));
	}
}
