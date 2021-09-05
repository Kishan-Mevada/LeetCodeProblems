package org.kishan.year_2021.month_september.date_5;

/**
 *   You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *   Find the maximum profit you can achieve. you may complete at most two transactions.
 *
 *   -- Time : O(n * 4) = O(n), where n is the length of the array, nested loop
 *   -- Space : O(2 * 3) = O(1), matrix
 */
public class MaxProfitBuySellStock3BU1 {

	static int maxProfit(int[] prices){
		int[][] maxProfit = new int[2][3];

		for(int i = prices.length - 1; i >= 0; i--){
			for(int state = 1; state >= 0; state--){
				for(int t = 1; t <= 2; t++) {
					if(state == 0){
						maxProfit[state][t] = Math.max(maxProfit[1][t] - prices[i], maxProfit[state][t]);
					}
					else{
						maxProfit[state][t] = Math.max(maxProfit[0][t-1] + prices[i], maxProfit[state][t]);
					}
				}
			}
		}
		return maxProfit[0][2];
	}

	public static void main(String[] args){
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println("Max Profit -> " + maxProfit(prices));
	}
}
