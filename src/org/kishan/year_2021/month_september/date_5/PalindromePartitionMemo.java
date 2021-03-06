package org.kishan.year_2021.month_september.date_5;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitionMemo {
		static List<List<String>> partition(String s){
			if(s.isEmpty()) return new ArrayList<>();

			return partition(0,s,new List[s.length()]);
		}
	private static List<List<String>> partition(int i, String s,List<List<String>>[] memo) {
		List<List<String>> result = new ArrayList<>();

		if(i >= s.length()){
			result.add(new ArrayList<>());
			return result;
		}

		if(memo[i] != null) return memo[i];

		StringBuilder sb = new StringBuilder();
		for(int j = i; j < s.length(); j++) {
			sb.append(s.charAt(j));

			if(isPalindrome(s,i,j)){
				List<List<String>> partitions = partition(j + 1, s,memo);
				for(List<String> par : partitions) {
					List<String> partition = new ArrayList<>();
					partition.add(sb.toString());
					partition.addAll(par);
					result.add(partition);
				}
			}
		}
		return memo[i]= result;
	}
	private static boolean isPalindrome(String s, int i, int j) {
		while(i < j){
			if(s.charAt(i++) != s.charAt(j--)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));
	}
}
