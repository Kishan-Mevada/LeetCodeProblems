package org.kishan.year_2021.month_september.date_4;

/**
 * 	-- Time : O(mn)), where m,n are the length of the s1 and s2, 2 for 2 choices
 * 	-- Space : O(n), array
 */
public class InterleavingStringBU1 {
	static boolean isInterLeave(String s1,String s2,String s3){
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		boolean[] interLeave = new boolean[s2.length() + 1];
		for(int i = s1.length(); i >= 0; i--) {
			for(int j = s2.length(); j >= 0; j--) {
				if(i == s1.length() && j == s2.length()){
					interLeave[j] = true;
					continue;
				}

				if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
					if(interLeave[j]){
						continue;
					}
				}
				if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
					if(interLeave[j+1]){
						interLeave[j] = true;
						continue;
					}
				}
				interLeave[j] = false;
			}
		}
		return interLeave[0];
	}

	public static void main(String[] args) {
		String s1 = "aabcc",s2 = "dbbca",s3 = "aadbbcbcac";
		System.out.println("Is InterLeaving -> " + isInterLeave(s1,s2,s3));
	}
}
