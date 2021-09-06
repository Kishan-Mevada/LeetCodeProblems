package org.kishan.year_2021.month_september.date_6;

/**
 *   You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *   Find the maximum profit you can achieve. you may complete at most two transactions.
 *
 *   -- Time : O(n * 4) = O(n), where n is the length of the array, nested loop
 *   -- Space : O(2 * 3) = O(1), matrix
 */
public class MaxProfitBuySellStock3BU2 {

	static int maxProfit(int[] prices,int k){
		int[][] maxProfit = new int[k+1][prices.length];
		for(int t = 1; t <= k; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			for(int j = 1; j < prices.length; j++) {
				maxSoFar = Math.max(maxSoFar,maxProfit[t-1][j-1] - prices[j-1]);
				maxProfit[t][j] = Math.max(maxProfit[t][j-1], maxSoFar + prices[j]);
			}
		}
		return maxProfit[k][prices.length-1];
	}

	public static void main(String[] args){
		int[] prices = {5,11,3,50,60,90};
		int k = 2;
		System.out.println("Max Profit -> " + maxProfit(prices,k));
	}
}
