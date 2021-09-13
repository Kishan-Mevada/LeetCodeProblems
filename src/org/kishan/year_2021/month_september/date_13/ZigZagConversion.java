package org.kishan.year_2021.month_september.date_13;

/**
 *
 * 	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *	And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

	static String convert(String s,int numRows){
		int dir = 1;
		int row = 0;
		// numRows could be min of given numRows and string length
		//Example numRows = 10, string length = 5, in this case zigzag conversion in 5 rows only
		StringBuilder[] sb = new StringBuilder[Math.min(numRows,s.length())];
		for(int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		for(int i = 0; i < s.length(); i++) {
			sb[row].append(s.charAt(i));
			row += dir;
			if(row == 0 || row == numRows-1){
				dir = dir == 1 ? -1 : 1;
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < sb.length; i++) {
			result.append(sb[i].toString());
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String s = "AB";
		int numRows = 1;
		System.out.println("ZigZag Conversion -> " + convert(s,numRows));
	}
}
