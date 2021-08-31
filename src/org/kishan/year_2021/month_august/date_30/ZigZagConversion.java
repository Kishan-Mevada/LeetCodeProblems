package org.kishan.year_2021.month_august.date_30;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  the string "PAYPALSHIRING" is written in zigzag pattern oon given number of rows
 *
 *  like
 *  	P   A   H   N
 *  	A P L S I I G
 *  	Y   I   R
 *
 *   Solution Algorithm
 *
 *   -  if numRows == 1
 *   		return s
 *   - create 3 variables
 *   	 - sbs[] , StringBuilder to kepp each characters
 *   	 - row, current row, initialize to 0
 *   	 - dir, current direction, initialize to 0
 *   - Iterate input string from 0 to last index, denoted as i
 *   	- get character at index i
 *      - increment row by dire (row += dir)
 *      - append character to sbs[row]
 *      - if row is ) or row is at last index
 *      	- if dir == 0
 *      	 	- set dir to 1
 *      	- else
 *      		- set dir to -dir
 *
 *    - now join the sbs and return single string
 */
public class ZigZagConversion {

	static String convert(String s,int numRows){
		if (numRows == 1) return s;

		StringBuilder[] sbs = new StringBuilder[numRows];

		int row = 0, dir = 0;
		for(int i = 0; i < numRows; i++) {
			sbs[i] = new StringBuilder();
		}

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			row += dir;
			sbs[row].append(c);

			if(row == 0 || row == numRows - 1){
				dir = (dir == 0) ? 1 : -dir;
			}
		}

		return String.join("", sbs);
	}
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println("Converted String -> " + convert(s,numRows));
	}
}
