package org.kishan;

import java.util.HashSet;
import java.util.Set;

/**
 *  Given a string s, find the length of the longest substring without repeating characters.
 *
 *  Solution Algorithm
 *
 *  - create 3 variables
 *  	- Set seen object to keep track of characters in our window
 *  	- i to be left boundary, initialize to 0
 *  	- max to keep track of the longest window
 *
 *  - Iterate string from index 0 to string.length -1
 *  	- get character at index j and assign variable c
 *  	- while seen contains c
 *  		- remove character that os located at index i from seen
 *  		- increment i
 *  	- Add c to seen
 *  	- update max if j - i + 1
 *
 *  return max
 *
 *  Time : O(n)
 *  Space : O(k), where k is number of unique chars
 */
public class LongestSubString {

	static int lengthOfLongestSubString(String s){
		Set<Character> seen = new HashSet<>();
		int i = 0,max = 0;
		for(int j = 0; j < s.length() -1 ; j++) {
			char c = s.charAt(j);
			while(seen.contains(c)){
				seen.remove(s.charAt(i++));
			}
			seen.add(c);
			max = Math.max(max,j - i + 1);
		}
		return max;
	}
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Longest sub string length -> " + lengthOfLongestSubString(s));
	}
}
