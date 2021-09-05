package org.kishan.year_2021.month_september.date_5;

/**
 *	You are climbing a staircase, it takes n steps to reach the top
 *
 * 	-- Time :  O(2 ^ n), where n is the input
 * 	-- Space : O(n), recursive call stack
 *
 */
public class ClimbStairs {

	static int climb(int n){
		if(n == 0 || n == 1) return 1;
		return climb(n-1) + climb(n-2);
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Climb Stairs steps-> " + climb(n));
	}
}
