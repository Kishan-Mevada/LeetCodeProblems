package org.kishan.year_2021.month_september.date_15;

/**
 *
 * 	Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * 	Input: s = "aa", p = "a*"
 * 	Output: true
 * 	Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * 	Input: s = "mississippi", p = "mis*is*p*."
 * 	Output: false
 *
 */
public class RegularExpMatching {
	/**
	 *
	 * @param s -> string
	 * @param p -> pattern
	 * @return true/false
	 */
	static boolean isMatchRec(String s, String p){
		if(p.isEmpty()) return s.isEmpty();

		boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

		if(p.length() > 1 && p.charAt(1) == '*'){
			return (isMatchRec(s,p.substring(2)) || (firstMatch && isMatchRec(s.substring(1),p)));
		}
		else{
			return firstMatch && isMatchRec(s.substring(1),p.substring(1));
		}
	}
	/**
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	static boolean isMatchConstantSpace(String s,String p){
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[s.length()][p.length()] = true;
		for(int i = s.length(); i >= 0 ; i--) {
			for(int j = p.length() - 1; j >= 0 ; j--) {
				boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

				if(j+1 < p.length() && p.charAt(j+1) == '*'){
					dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
				}
				else{
					dp[i][j] = firstMatch && dp[i+1][j+1];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println("Is Match -> " + isMatchRec(s,p));
		System.out.println("Is Match -> " + isMatchConstantSpace(s,p));
	}
}
