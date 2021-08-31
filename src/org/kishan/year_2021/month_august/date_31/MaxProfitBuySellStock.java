package org.kishan.year_2021.month_august.date_31;

/**
 *  you are given an array prices where prices[i] is the price of a given stock on ith day
 *  find the maximum profit by choosing a signle day to buy 1 stock and choosing different day
 *  in future to sell that stock
 *
 *  Solution Algorithm
 *
 *  - if prices is empty or null
 *  	- return 0
 *  - create 2 variables
 *  	- maxProfit, to keep maximum profit we can generate , initialize to 0
 *  	- minPrice, to keep previous minimum price, initialize to prices[0]
 *
 *  - Iterate the prices array
 *  	- update maxProfit if prices[i] - minPrice is greater
 *      - update minPrice if prices[i] is smaller
 *
 *  - return maxProfit
 *
 *  Time : O(n)
 *  Space : O(1)
 */
public class MaxProfitBuySellStock {

	static int maxProfit(int[] prices){
		if (prices == null || prices.length == 0) return 0;
		int maxProfit =0, minPrice = prices[0];
		for(int i = 1;i<prices.length;i++){
			maxProfit = Math.max(maxProfit,prices[i] - minPrice);
			minPrice = Math.min(minPrice,prices[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args){
		int[] prices = {7,6,4,3,1}; // case1
		int[] prices1 = {7,1,5,3,6,4}; // case2
		System.out.println("Max Profit (case 1) -> " + maxProfit(prices));
		System.out.println("Max Profit (case 2) -> " + maxProfit(prices1));
	}
}
