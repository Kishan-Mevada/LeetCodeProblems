package org.kishan.year_2021.month_september.date_13;

/**
 * 	Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 * Input: x = 121
 * Output: true
 *
 * Input: x = -121
 * Output: false
 *
 * Constraints:
 * 	-2^31 <= x <= 2^31 - 1
 */
public class PalindromeNumber {

	static boolean isPalindrome(int x) {
		int temp = x;
		int retVal = 0;
		while(temp > 0){
			int mod = temp % 10;
			temp /= 10;
			if(retVal > Integer.MAX_VALUE / 10 || (retVal == Integer.MAX_VALUE / 10 && mod > 7)) return false;
			if(retVal < Integer.MIN_VALUE / 10 || (retVal == Integer.MIN_VALUE / 10 && mod < -8)) return false;
			retVal = retVal * 10 + mod;
		}
		return retVal == x;
	}
	public static void main(String[] args) {
		System.out.println("Is Palindrome(123) -> " + isPalindrome(123));
		System.out.println("Is Palindrome(-123) -> " + isPalindrome(-123));
		System.out.println("Is Palindrome(INT_MAX-10) -> " + isPalindrome(Integer.MAX_VALUE - 10));
		System.out.println("Is Palindrome(INT_MIN-10) -> " + isPalindrome(Integer.MIN_VALUE - 10));
	}
}
