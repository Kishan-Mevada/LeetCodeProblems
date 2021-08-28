package org.kishan;

/**
 * Solution Algorithm (Binary Search approach)
 *
 * - Create 2 Variables
 * 		- left for left bound, initialize to 0
 * 		- right for right bound, initialize to (x/2) + 1
 * - while left < right
 * 		- calculate mid
 * 			 - mid = left + (right - left) / 2 + 1
 * 		- calculate square
 * 			 - square = mid * mid
 * 		- if square == x
 * 			return mid
 * 		  else if square < x
 * 		  	left = mid
 * 		  else
 * 		  	right = mid + 1
 *
 *   return left ,->  left * left will be largest square that is less than x
 */

public class SquareRoot {

	static int sqrt(int x){
		long left = 0, right = (x/2) + 1;
		while(left < right){
			long mid = left + (right - left) / 2 + 1;
			long square = mid * mid;

			if(square == x){
				return (int)mid;
			}
			else if(square < x){
				left = mid;
			}
			else{
				right = mid - 1;
			}
		}
		return (int) left;
	}
	public static void main(String[] args) {
		int x = 64;
		System.out.println(sqrt(x));
	}
}
