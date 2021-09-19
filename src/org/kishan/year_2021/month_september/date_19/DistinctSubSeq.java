package org.kishan.year_2021.month_september.date_19;

import java.util.Arrays;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 */
public class DistinctSubSeq {

	static int numDistinct(String s, String t) {
		int[][] cache = new int[s.length()][t.length()];
		for(int[] c : cache){
			Arrays.fill(c,-1);
		}
		return numDistinct(s,t,0,0,cache);
	}

	static int numDistinct(String s, String t,int i, int j,int[][] cache) {
		if(j == t.length()) return 1;
		if(i == s.length()) return 0;
		if(cache[i][j] != -1) return cache[i][j];

		int sub = numDistinct(s,t,i+1,j,cache);

		if(s.charAt(i) == t.charAt(j)){
			sub += numDistinct(s,t,i+1,j+1,cache);
		}

		return cache[i][j] = sub;
	}
	public static void main(String[] args) {
		String s = "rabbbit", t = "rabbit";
		System.out.println("Distinct sub sequence -> " + numDistinct(s,t));
	}
}

