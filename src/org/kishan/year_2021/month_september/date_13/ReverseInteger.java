package org.kishan.year_2021.month_september.date_13;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2'31, 2'31 - 1], then return 0.
 *
 * Input: x = 123
 * Output: 321
 */
public class ReverseInteger {

	static int reverse(int n){
		int rev = 0;
		while(n != 0){
			int mod = n % 10;
			n /= 10;
			if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
			if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && mod < -8)) return 0;
			rev = rev * 10 + mod;
		}
		return rev;
	}
	public static void main(String[] args) {
		System.out.println(reverse(Integer.MAX_VALUE));
		System.out.println(reverse(Integer.MIN_VALUE));
		System.out.println(reverse(-123));
		System.out.println(reverse(4554));
	}
}
