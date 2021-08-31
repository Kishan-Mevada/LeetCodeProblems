package org.kishan.year_2021.month_august.date_30;

import java.util.Arrays;

/**
 * 	A message containing letters from A-Z can be encoded into numbers using the following mapping
 * 		A -> 1
 * 		B -> 2
 * 		...
 * 		Z -> 26
 *
 * 	example AAJF = (1 1 10 6)
 *
 * 	input 12
 * 	output 2  : (1,12)
 *
 * 	Solution Algorithm
 *
 * 	Recursive approach : this approach may lead to time limit exceed
 *
 *	- create a recursive method which takes index,string input
 *		- base case
 *			- if index >= string.length
 *				- return 1;
 *		- in recursive call
 *			- create variable ways, initialize to 0
 *			- create num1, which will be the numeric value of the char at given index
 *			- create num2, which wii be decode two digits
 *					- if index is not at last index
 *						- retrieve 2 digits, 'c' and 'd' form indices index and index + 1
 *						- set num2 = c * 10 + 2;
 *				    - Else
 *				    	- set num2 = 0
 *			- if num1 is between 1 and 9
 *				- Recursively find the numbers of ways y from index + 1
 *				- increment ways by y
 *		  	- if num2 is between 10 and 26
 *  			- Recursively find the numbers of ways y from index + 2
 *  			- increment ways by y
 *			- return ways
 *
 *	Time : (2^n) : each recursive call has 2 choices of depth of n
 *  Space : O(n)
 *
 *
 * 	Memoization Approach
 *	- create a recursive method which takes index,string input,array of memo[] fill with -1 to cache already calculate
 *		- base case
 *			- if index >= string.length
 *				- return 1;
 *		 	- if memo[i] != -1
 *		 		- return memo[i]
 *		- in recursive call
 *			- create variable ways, initialize to 0
 *			- create num1, which will be the numeric value of the char at given index
 *			- create num2, which wii be decode two digits
 *					- if index is not at last index
 *						- retrieve 2 digits, 'c' and 'd' form indices index and index + 1
 *						- set num2 = c * 10 + 2;
 *				    - Else
 *				    	- set num2 = 0
 *			- if num1 is between 1 and 9
 *				- Recursively find the numbers of ways y from index + 1 with memo
 *				- increment ways by y
 *		  	- if num2 is between 10 and 26
 *  			- Recursively find the numbers of ways y from index + 2 with memo
 *  			- increment ways by y
 *			- return memo[i] = ways
 *
 *	Time	 : 	O(n), where n is length of input
 *	Space	 :  O(2 * n) = O(n)
 *				O(n) -> memo
 *				O(n) -> recursive call stack
 */
public class DecodeWays {

	static int numDecodings(String s){
		return numDecodings(0,s);
	}
	private static int numDecodings(int i, String s) {
		if (i >= s.length()) return 1;
		int ways = 0;
		int num1 = Character.getNumericValue(s.charAt(i));
		int num2 = (i != s.length() -1) ?
				Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i+1)) : 0;

		if (num1 >=1 && num1 <= 9){
			ways += numDecodings(i+1,s);
		}
		if(num2 >= 10 && num2 <= 26){
			ways += numDecodings(i+2,s);
		}
		return ways;
	}

	static int numDecodingsMemo(String s){
		int[] memo = new int[s.length()];
		Arrays.fill(memo,-1);
		return numDecodingsMemo(0,s,memo);
	}
	private static int numDecodingsMemo(int i, String s,int[] memo) {
		if (i >= s.length()) return 1;
		if (memo[i] != -1) return memo[i];
		int ways = 0;
		int num1 = Character.getNumericValue(s.charAt(i));
		int num2 = (i != s.length() -1) ?
				Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i+1)) : 0;

		if (num1 >=1 && num1 <= 9){
			ways += numDecodingsMemo(i+1,s,memo);
		}
		if(num2 >= 10 && num2 <= 26){
			ways += numDecodingsMemo(i+2,s,memo);
		}
		return memo[i] = ways;
	}

	public static void main(String[] args) {
		String input = "226";
		System.out.println("No of ways to decode -> " + numDecodings(input));
	}
}
