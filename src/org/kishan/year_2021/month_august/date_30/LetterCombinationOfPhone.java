package org.kishan.year_2021.month_august.date_30;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {

	private static final char[][] LETTERS = {
			{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
			{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

	static List<String> letterCombination(String digits){
		if (digits.isEmpty()) return new ArrayList<>();

		List<String> result = new ArrayList<>();
		letterCombinations(0,new StringBuilder(),result,digits);
		return result;
	}

	private static void letterCombinations(int i, StringBuilder str, List<String> result, String digits) {
		if (i >= digits.length()){
			result.add(str.toString());
			return;
		}

		char d = digits.charAt(i);

		for(char c : LETTERS[Character.getNumericValue(d)]){
			str.append(c);
			letterCombinations(i+1,str,result,digits);
			str.deleteCharAt(str.length() - 1);
		}
	}
	public static void main(String[] args) {
		String digits = "23";
		System.out.println("Letter combination of Phone Number -> " + letterCombination(digits));
	}
}
