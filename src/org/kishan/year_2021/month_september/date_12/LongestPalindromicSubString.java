package org.kishan.year_2021.month_september.date_12;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 */
public class LongestPalindromicSubString {

	static String longestPalindrome(String s){
		if(s == null || s.isEmpty()) return "";
		int maxLength = 0;
		int start = 0;
		for(int i = 0; i < s.length(); i++) {
			int length = Math.max(palindromeSoFar(i,i,s), palindromeSoFar(i,i+1,s));
			if(length > maxLength){
				maxLength = length;
				start = i - (length - 1) / 2;
			}
		}
		return s.substring(start, start + maxLength);
	}
	private static int palindromeSoFar(int i, int j, String s) {
		if(j >= s.length()) return 0;
		int len = (i == j) ? -1 : 0;
		while(i >= 0 && j < s.length()){
			if(s.charAt(i) != s.charAt(j)) break;
			len += 2;
			i--;
			j++;
		}
		return len;
	}
	public static void main(String[] args) {
		String s = "a";
		System.out.println("Longest Palindromic SubString -> " + longestPalindrome(s));
	}
}
