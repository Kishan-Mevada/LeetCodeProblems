package org.kishan.year_2021.month_september.date_4;

/**
 * 		-- Time : O(m*n), where m,n are length of the s and t, for nested loop
 * 		-- Space : O(m*n), subsequences
 *
 * 		-- Recursive approach may lead to the Time Limit exceed
 */
public class DistinctSubSequenceBU {

	static int numDistinct(String s,String t){
		int[][] subSeq = new int[s.length()+1][t.length()+1];
		for(int i = s.length(); i >= 0; i--) {
			for(int j = t.length(); j >= 0; j--) {
				if(j == t.length()){
					subSeq[i][j] = 1;
					continue;
				}

				if(i == s.length()) continue;

				subSeq[i][j] += subSeq[i+1][j];

				if(s.charAt(i) == t.charAt(j)){
					subSeq[i][j] += subSeq[i+1][j+1];
				}
			}
		}
		return subSeq[0][0];
	}


	public static void main(String[] args){
		String s = "rabbbit", t = "rabbit";
		System.out.println("Distinct sub sequences -> " + numDistinct(s,t));
	}
}
