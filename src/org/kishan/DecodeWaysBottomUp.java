package org.kishan;

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
 * 	Solution algorithm : Button up approach
 *
 * 	- create an array ways to keep track of the number of ways
 * 	- Iterate from s.length() to 0, denoted as i
 * 		- if i == s.length()
 * 			- set ways[i] = 1
 * 			- continue to next iteration
 * 		- create num1, which will be the numeric value of the char at given i index
 * 		- create num2, which wii be decode two digits
 * 			- if index is not at last index
 *				- retrieve 2 digits, 'c' and 'd' form indices index and index + 1
 *				- set num2 = c * 10 + 2;
 *			- Else
 *				- set num2 = 0
 *		- if num1 is in between 1 and 9
 *			- increment ways[i] by ways[i+1]
 *		- if num2 is in between 10 and 26
 *			- increment ways[i] by ways[i+2]
 *	return ways[0];
 *
 * 	Time	: O(n)
 * 	Space	: O(n), for ways array
 */
public class DecodeWaysBottomUp {

	static int numDecodings(String s){
		int[] ways = new int[s.length()+1];
		for(int i = s.length(); i >= 0 ; i--) {
			if( i == s.length()){
				ways[i] = 1;
				continue;
			}
			int num1 = Character.getNumericValue(s.charAt(i));
			int num2 = (i != s.length() - 1) ?
						Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i+1)) : 0;
			if(num1 >= 1 && num1 <= 9){
				ways[i] += ways[i+1];
			}
			if(num2 >= 10 && num2 <= 26){
				ways[i] += ways[i+2];
			}
		}
		return ways[0];
	}

	//constant space approach
	// Time : O(n)
	// Space : O(1)
	static int numDecodingsConstantSpace(String s){
		int ways1 = 1, ways2 = 0;
		for(int i = s.length() - 1; i >= 0 ; i--) {
		 	int ways = 0;
			int num1 = Character.getNumericValue(s.charAt(i));
			int num2 = (i != s.length() - 1) ?
					Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i+1)) : 0;
			if(num1 >= 1 && num1 <= 9){
				ways += ways1;
			}
			if(num2 >= 10 && num2 <= 26){
				ways += ways2;
			}
			ways2 = ways1;
			ways1 = ways;
		}
		return ways1;
	}

	public static void main(String[] args) {
		String input = "125";
		System.out.println("No of ways to decode -> " + numDecodingsConstantSpace(input));
	}
}


