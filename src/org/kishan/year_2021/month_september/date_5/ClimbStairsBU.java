package org.kishan.year_2021.month_september.date_5;

/**
 *	You are climbing a staircase, it takes n steps to reach the top
 *
 * 	-- Time :  O(n), where n is the input
 * 	-- Space : O(n), ways array
 *
 */
public class ClimbStairsBU {

	static int climb(int n){
		if(n == 0 || n == 1) return 1;

		int[] ways = new int[n+1];
		ways[0] = ways[1] = 1;
		for(int i = 2; i <= n; i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
		return ways[n];
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Climb Stairs steps-> " + climb(n));
	}
}
