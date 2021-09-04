package org.kishan.year_2021.month_september.date_4;

/**
 * 		-- Time : O(m*n), where m,n are length of the s and t, for nested loop
 * 		-- Space : O(n), subsequences array
 *
 * 		-- Recursive approach may lead to the Time Limit exceed
 */
public class DistinctSubSequenceBU1 {

	static int numDistinct(String s,String t){
		int[] subSeq = new int[t.length()+1];
		for(int i = s.length(); i >= 0; i--) {
			int prev = 0;
			for(int j = t.length(); j >= 0; j--) {
				if(j == t.length()){
					prev = subSeq[j];
					subSeq[j] = 1;
					continue;
				}

				if(i == s.length()) {
					prev = subSeq[j];
					subSeq[j] = 0;
					continue;
				}

				int cur = subSeq[j];

				if(s.charAt(i) == t.charAt(j)){
					subSeq[j] += prev;
				}
				prev = cur;
			}
		}
		return subSeq[0];
	}


	public static void main(String[] args){
		String s = "rabbbit", t = "rabbit";
		System.out.println("Distinct sub sequences -> " + numDistinct(s,t));
	}
}
