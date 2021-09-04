package org.kishan.year_2021.month_september.date_4;

/**
 * 		-- Time : O(2^(m+n)), where m,n are length of the s and t, and 2 for 2 choices
 * 		-- Space : O(m+n), recursive call stack
 *
 * 		-- Recursive approach may lead to the Time Limit exceed
 */
public class DistinctSubSequence {

	static int numDistinct(String s,String t){
		return numDistinct(s,t,0,0);
	}
	private static int numDistinct(String s, String t, int i, int j) {
		if(j == t.length()) return 1;
		if(i == s.length()) return 0;

		int subSeq = numDistinct(s,t,i+1,j);

		if(s.charAt(i) == t.charAt(j)){
			subSeq += numDistinct(s,t,i+1,j+1); // move both index if both char are same
		}
		return subSeq;
	}

	public static void main(String[] args){
		String s = "rabbbit", t = "rabbit";
		System.out.println("Distinct sub sequences -> " + numDistinct(s,t));
	}
}
