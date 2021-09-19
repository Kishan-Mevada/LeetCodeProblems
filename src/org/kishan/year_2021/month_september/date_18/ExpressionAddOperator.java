package org.kishan.year_2021.month_september.date_18;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators
 * 	'+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 * 	Input: num = "123", target = 6
 *  Output: ["1*2*3","1+2+3"]
 *
 *
 */
public class ExpressionAddOperator {

	static List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		addOperators(res, sb, num, 0, target, 0, 0);
		return res;
	}

	static void addOperators(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi)     {
		if(pos == num.length()) {
			if(target == prev) res.add(sb.toString());
			return;
		}
		for(int i = pos; i < num.length(); i++) {
			if(num.charAt(pos) == '0' && i != pos) break;
			long curr = Long.parseLong(num.substring(pos, i + 1));
			int len = sb.length();
			if(pos == 0) {
				addOperators(res, sb.append(curr), num, i + 1, target, curr, curr);
				sb.setLength(len);
			} else {
				addOperators(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
				sb.setLength(len);
				addOperators(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
				sb.setLength(len);
				addOperators(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
				sb.setLength(len);
			}
		}
	}


	public static void main(String[] args) {
		String num = "123";
		int target = 6;
		System.out.println(addOperators(num,target));
	}
}
