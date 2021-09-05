package org.kishan.year_2021.month_september.date_5;

/**
 *   You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *   Find the maximum profit you can achieve. you may complete at most two transactions.
 *
 *   Solution Algorithm (Recursive approach)
 *
 *   - Create following parameter
 *   	- i, out current index
 *   	- s, current state ( 0 = Buy, 1 = Sell)
 *   	- t, number of transaction left
 *   	- prices, input prices array
 *
 *   - base condition
 *   	- if i is out of bound and t is 0
 *   		- return 0
 *   - in each recursive call
 *   	- if s is 0
 *   		- Recursively find the profit p1 if we buy current stock
 *   			- i = i + 1
 *   			- s = 1 (Sell)
 *   		- Recursively find the profit p2 if we sell at the current stock
 *   			- i = i + 1
 *   		- Return max(p1 - prices[i],p2)
 *   	- else
 *   		- Recursively find the profit p1 if we buy current stock
 *   			- i = i + 1
 *   			- s = 0 (buy)
 *   			- t = t - 1
 *   		- Recursively find the profit p2 if we sell at the current stock
 *   			- i = i + 1
 *   		- Return max(p1 - prices[i],p2)
 *
 *   -- Time : O(2^n) = O(n), where n is the length of the array and each recursive call has 2 choices
 *   -- Space : O(n), recursive call stack memory
 */
public class MaxProfitBuySellStock3 {

	static int maxProfit(int[] prices){
		return maxProfit(0,0,2,prices);
	}
	private static int maxProfit(int i, int s, int t, int[] prices) {
		if(i >= prices.length || t == 0) return 0;
		if(s == 0){//buy
			return Math.max(maxProfit(i+1,1,t,prices) - prices[i],
				   			maxProfit(i+1,s,t,prices));
		}
		else{//sell
			return Math.max(maxProfit(i+1,0,t-1,prices) + prices[i],
					maxProfit(i+1,s,t,prices));
		}
	}

	public static void main(String[] args){
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println("Max Profit -> " + maxProfit(prices));
	}
}
