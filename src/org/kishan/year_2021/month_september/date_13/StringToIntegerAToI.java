package org.kishan.year_2021.month_september.date_13;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 *
 * 	Read in and ignore any leading whitespace.
 * 	Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * 	Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * 	Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 	If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * 	Return the integer as the final result.
 *
 * 	Note:
 * 		Only the space character ' ' is considered a whitespace character.
 * 		Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class StringToIntegerAToI {

	static int myAtoI(String s){
		boolean isDigitStart = false;
		boolean hasNegative = false;
		int intVal = 0;
		int retVal = 0;
		s = s.trim();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' && !isDigitStart) {
				isDigitStart = true;
				continue;
			} else if (c == '-' && !isDigitStart) {
				isDigitStart = true;
				hasNegative = true;
				continue;
			} else if ((c >= '0' && c <= '9') && !isDigitStart) {
				isDigitStart = true;
			} else if ((c < '0' || c > '9')) {
				return hasNegative ? -retVal : retVal;
			}
			// digitStarted
			intVal = c - 48;
			if (retVal > Integer.MAX_VALUE / 10) {
				return hasNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			} else if (retVal == Integer.MAX_VALUE / 10) {
				if (!hasNegative && intVal >= 7) {
					return Integer.MAX_VALUE;
				} else if (hasNegative && intVal >= 8) {
					return Integer.MIN_VALUE;
				}
				retVal = retVal * 10 + intVal;
			} else {
				retVal = retVal * 10 + intVal;
			}
		}
		return hasNegative ? -retVal : retVal;
	}
	public static void main(String[] args) {
		System.out.println(myAtoI("42"));
		System.out.println(myAtoI("-42"));
		System.out.println(myAtoI("    -42"));
		System.out.println(myAtoI("   42"));
		System.out.println(myAtoI("hello 42"));
		System.out.println(myAtoI("   123 hello"));
		System.out.println(myAtoI("-2147483647"));
		System.out.println(myAtoI("00000-42a1234"));
	}
}
