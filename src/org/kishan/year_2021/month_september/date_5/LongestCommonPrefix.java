package org.kishan.year_2021.month_september.date_5;

import java.util.Arrays;

/**
 * 	write function to find the longest common prefix string amongst an array of strings
 *
 * 	if there is no common prefix,return empty string
 *
 * 	input		output
 * 	[flower,	fl
 * 	 flow,
 * 	 flight]
 *
 * 	 [dog,		""
 * 	  car,
 * 	  racecar]
 *
 * 	-- Time : O(n * k), where n is number of strings and k is the number chars associated with each string
 * 	-- Space : O(k), where k us number of chars associated with each string
 */
public class LongestCommonPrefix {

	static String longestCommonPrefix(String[] strs){
		if(strs.length == 0) return "";

		int length = strs[0].length();
		for(int i = 0; i < strs.length; i++) {
			length = Math.min(length,strs[i].length());
			for(int j = 0; j < length; j++) {
				if(strs[0].charAt(j) != strs[i].charAt(j)){
					length = j;
					break;
				}
			}
		}
		return strs[0].substring(0,length);
	}
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println("Longest Common Prefix of " + Arrays.toString(strs) + " -> " + longestCommonPrefix(strs));

		String[] strs1 = {"dog","car","racecar"};
		System.out.println("Longest Common Prefix of " + Arrays.toString(strs1) + " -> " + longestCommonPrefix(strs1));
	}
}
