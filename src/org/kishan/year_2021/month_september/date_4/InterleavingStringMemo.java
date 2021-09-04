package org.kishan.year_2021.month_september.date_4;

/**
 * 	-- Time : O(m+n), where m,n are the length of the s1 and s2
 * 	--Space : O(m + n), recursive stack
 */
public class InterleavingStringMemo {
	static boolean isInterLeave(String s1,String s2,String s3){
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		return isInterLeave(s1,s2,s3,0,0,new Boolean[s1.length()+1][s2.length()+1]);
	}
	private static boolean isInterLeave(String s1, String s2, String s3, int i, int j,Boolean[][] memo) {
		if(i == s1.length() && j == s2.length()) return true;
		if(memo[i][j] != null) return memo[i][j];

		if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
			if(isInterLeave(s1,s2,s3,i+1,j,memo)) return memo[i][j] = true;
		}
		if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
			if(isInterLeave(s1,s2,s3,i,j+1,memo)) return memo[i][j] = true;
		}
		return false;
	}
	public static void main(String[] args) {
		String s1 = "aabcc",s2 = "dbbca",s3 = "aadbbcbcac";
		System.out.println("Is InterLeaving -> " + isInterLeave(s1,s2,s3));
	}
}
