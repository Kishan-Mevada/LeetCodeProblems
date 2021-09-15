package org.kishan.year_2021.month_september.date_14;

public class LongestCommonPrefix {
	static String longestCommonPrefix(String[] strs) {
		int i = 0;
		for(i = 0;i < strs[0].length(); i++){
			char c = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++){
				if(strs[j].length() == i || strs[j].charAt(i) != c){
					return strs[0].substring(0,i);
				}
			}
		}
		return strs[0].substring(0,i);
	}

	// Time : O(n), Space : O(1)
	static String lcp1(String[] strs){
		if(strs == null || strs.length == 0) return "";
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0,prefix.length()-1);
				if(prefix.isEmpty()){
					return "";
				}
			}
		}
		return prefix;
	}

	// Time : O(S), Space : O(S), where S is the number of characters in array
	static String lcp2(String[] strs){
		if(strs == null || strs.length == 0) return "";
		return lcp2(strs,0,strs.length - 1);
	}
	private static String lcp2(String[] strs, int l, int r) {
		if(l == r){
			return strs[l];
		}
		int mid = (l+r)/2;
		String leftLCP = lcp2(strs, l, mid);
		String rightLCP = lcp2(strs, mid+1, r);
		return commonPrefix(leftLCP,rightLCP);
	}
	private static String commonPrefix(String leftLCP, String rightLCP) {
		int min = Math.min(leftLCP.length(),rightLCP.length());
		for(int i = 0; i < min; i++) {
			if(leftLCP.charAt(i) != rightLCP.charAt(i)) return leftLCP.substring(0,i);
		}
		return leftLCP.substring(0,min);
	}
	public static void main(String[] args) {
		String[] strs = {"ab","a"};
		System.out.println("Longest Common Prefix -> " + lcp2(strs));
	}
}
