package org.kishan.year_2021.month_september.date_5;

/**
 *	You are climbing a staircase, it takes n steps to reach the top
 *
 * 	-- Time :  O(n), where n is the input
 * 	-- Space : O(1),
 *
 */
public class ClimbStairsBU1 {

	static int climb(int n){
		if(n == 0 || n == 1) return 1;

		int ways1 = 1;
		int ways2 = 1;
		for(int i = 2; i <= n; i++) {
			int ways = ways1 + ways2;
			ways2 = ways1;
			ways1 = ways;
		}
		return ways1;
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Climb Stairs steps-> " + climb(n));
	}
}
