package org.kishan.year_2021.month_august.date_31;

public class ReverseString {

	static String reverseRec(String str){
		if(str == null || str.length() <= 1){
			return str;
		}
		return reverseRec(str.substring(1)) + str.charAt(0);
	}

	static String reverse(String str){
		if(str == null || str.length() < 1){
			return str;
		}
		int start = 0;
		int end = str.length() - 1;
		char[] chars = str.toCharArray();
		while(start < end){
			char c = chars[start];
			chars[start] = chars[end];
			chars[end] = c;
			start++;
			end--;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String str = "abc";
		System.out.println("Reverse String by recursive method -> " + reverseRec(str));
		System.out.println("Reverse String by recursive method -> " + reverse(str));
	}
}
