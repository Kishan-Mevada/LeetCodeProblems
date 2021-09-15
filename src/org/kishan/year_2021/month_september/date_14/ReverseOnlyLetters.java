package org.kishan.year_2021.month_september.date_14;

import java.util.Arrays;

/**
 * 	Given a string s, reverse the string according to the following rules:
 *
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 *
 * -- Time : O(n), where n is length of the string
 * -- Space : O(n), chars array
 *
 */
public class ReverseOnlyLetters {

	static String reverseOnlyLetters(String s) {
		char[] chars = s.toCharArray();
		int start = 0, end = s.length() - 1;
		while(start < end){
			if(!Character.isAlphabetic(chars[start])){
				start++;
			}
			else if(!Character.isAlphabetic(chars[end])){
				end--;
			}
			else{
				char c = chars[start];
				chars[start] = chars[end];
				chars[end] = c;
				start++;
				end--;
			}
		}
		return new String(chars);
	}
	public static void main(String[] args) {
		String s = "a-bC-dEf-ghIj";
		System.out.println("Reverse only letters -> " + reverseOnlyLetters(s));
	}
}
