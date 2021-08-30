package org.kishan;

/**
 * 	Solution Algorithm
 *
 * 	- Create 2 variables
 * 		- maxLength, maximum number of palindromic substring
 * 		- start, start index of substring, initialize to -1
 *
 * 	- Iterate all character from give string, denoted as i
 * 		- find the length of palindromic substring 'length1' if we use current index
 * 	    - find the length of palindromic susbstring ;length2; if we skip current index (i + 1)
 * 	    - length = max(length1,length2)
 * 	    - if length > maxLength
 * 	    	- maxLength = length
 * 	    	- update start to i - (length -1) / 2
 *  - return substring from start -> start + maxLength - 1;
 *
 *  Time : O(n^2),
 *  Space : O(k), where k is generated substring
 */
public class LongestPalindromicSubString {

	public static String lps(String s){
		int maxLength = 0, start = -1;
		for(int i = 0; i < s.length(); i++) {
			int length = Math.max(getLength(i,i,s), getLength(i,i+1,s));

			if(length > maxLength){
				maxLength = length;
				start = i - (length - 1) / 2;
			}
		}

		return s.substring(start,start + maxLength);
	}
	private static int getLength(int i, int j, String s) {
		if (j >= s.length()) return 0;
		int length = (i == j) ? -1 : 0;

		while(i >= 0 && j < s.length()){
			if(s.charAt(i) != s.charAt(j)) break;

			length += 2;
			i--;
			j++;
		}
		return length;
	}
	public static void main(String[] args) {
		String s = "bababd";
		System.out.println("Longest Palindromic substring -> " + lps(s));
	}
}
