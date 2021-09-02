package org.kishan.year_2021.month_september.date_2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 	Given a non-empty array of the decimal digits representing non-negative integer, increment one to the integer
 * 	The digits are stored to such that the most significant digit is the head of the list and each array element contain single digit
 *
 * 	input				output
 * 	[1,2,3]				[1,2,4]
 * 	[4,3,2,1]			[4,3,2,2]
 *
 * 	- create an linked list result of input array
 * 	- create carry to keep carry, initialize to 1
 * 	- create sum variable
 * 	- Iterate input array from right side (inputArr.length - 1), denoted as i
 * 		- find the sum
 * 			- sum = inputArr[i]	+ carry
 * 		- if sum > 9
 * 			- carry = 1
 * 		else
 * 			- carry = 0
 * 		- set prepend  sum % 10 to result
 *
 * - return convert linked list to array
 *
 * 	-- Time : O(n)
 * 	-- Space : O(n)
 */
public class PlusOne {

	static int[] plusOne(int[] digits){
		LinkedList<Integer> result = new LinkedList<>();
		int carry = 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			result.addFirst(sum % 10);
		}
		return result.stream().mapToInt(x -> x).toArray();
	}

	public static void main(String[] args) {
		int[] digits = {1,2,9};
		System.out.println("Plus One -> " + Arrays.toString(plusOne(digits)));
	}
}
