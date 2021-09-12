package org.kishan.year_2021.month_september.date_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 */
public class LongestUniqueSubString {

	static int lengthOfUniqueSubString(String s){
		Set<Character> seen = new HashSet<>();
		int length = 0,i = 0;
		for(int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			while(seen.contains(c)){
				seen.remove(s.charAt(i++));
			}
			seen.add(c);
			length = Math.max(length,(j-i)+1);
		}
		return length;
	}
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Length of longest sub string -> " + lengthOfUniqueSubString(s));
	}
}
