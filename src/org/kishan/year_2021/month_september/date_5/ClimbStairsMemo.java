package org.kishan.year_2021.month_september.date_5;

/**
 *	You are climbing a staircase, it takes n steps to reach the top
 *
 * 	-- Time :  O(n), where n is the input
 * 	-- Space : O(n), recursive call stack + memo
 *
 */
public class ClimbStairsMemo {

	static int climb(int n){
		return climb(n,new int[n+1]);
	}

	static int climb(int n,int[] memo){
		if(n == 0 || n == 1) return 1;
		if(memo[n] != 0) return memo[n];
		return memo[n] = climb(n - 1,memo) + climb(n - 2,memo);
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println("Climb Stairs steps-> " + climb(n));
	}
}
