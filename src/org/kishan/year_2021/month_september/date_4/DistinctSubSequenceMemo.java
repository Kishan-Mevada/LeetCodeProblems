package org.kishan.year_2021.month_september.date_4;

import java.util.Arrays;

/**
 * 		-- Time : O(m*n) + O(m*n) = O(m*n), where m,n are length of the s and t
 * 			-- 	O(m*n), fill the memo matrix
 * 		-- Space : O(m*n) + O(m*n) = O(m*n),
 * 			-- O(m*n), memo
 * 			-- O(m*n), recursive call stack
 */
public class DistinctSubSequenceMemo {

	static int numDistinct(String s,String t){
		int[][] memo = new int[s.length()][t.length()];
		for(int[] m : memo){
			Arrays.fill(m,-1);
		}
		return numDistinct(s,t,0,0,memo);
	}
	private static int numDistinct(String s, String t, int i, int j,int[][] memo) {
		if(j == t.length()) return 1;
		if(i == s.length()) return 0;
		if(memo[i][j] != -1) return memo[i][j];

		int subSeq = numDistinct(s,t,i+1,j,memo);

		if(s.charAt(i) == t.charAt(j)){
			subSeq += numDistinct(s,t,i+1,j+1,memo); // move both index if both char are same
		}
		return memo[i][j] = subSeq;
	}

	public static void main(String[] args){
		String s = "rabbbit", t = "rabbit";
		System.out.println("Distinct sub sequences -> " + numDistinct(s,t));
	}
}
