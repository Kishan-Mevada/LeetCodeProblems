package org.kishan.year_2021.month_september.date_5;

import java.util.Stack;

/**
 * 		input		output
 * 		()			true
 * 		(){}[]		true
 * 		(}			false
 * 		({})		true
 *
 * 		-- Time : O(n)
 * 		-- Space : O(n), stack
 */
public class ValidParentheses {

	private static final String OPENING_BRACKETS = "({[";
	private static final String CLOSING_BRACKETS = ")}]";

	static boolean isValid(String s){
		Stack<Character> stack = new Stack();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(isOpeningBracket(c)){
				stack.add(c);
			}
			else {
				if(stack.isEmpty() || !isMatching(stack.pop(),c)){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	private static boolean isOpeningBracket(char c) {
		return OPENING_BRACKETS.indexOf(c) != -1;
	}

	private static boolean isMatching(char open,char close){
		return OPENING_BRACKETS.indexOf(open) == CLOSING_BRACKETS.indexOf(close);
	}
	public static void main(String[] args) {
		String s1 = "(){}";
		String s2 = "([])";
		String s3 = "({)}";
		System.out.println(s1 + " is valid parentheses -> " + isValid(s1));
		System.out.println(s2 + " is valid parentheses -> " + isValid(s2));
		System.out.println(s3 + " is valid parentheses -> " + isValid(s3));
	}
}
