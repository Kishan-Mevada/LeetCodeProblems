package org.kishan;

/**
 *  You have an array prices for which the i'th element is the price of given stock on day i.
 *
 *  Design algo to find maximum profit, you may complete as many transaction as you like
 *  (buy one and sell one share of stock multiple times)
 *
 *  but you must sell the stock before you buy again
 *
 *  Solution Algorithm
 *
 *  - if prices is empty or null
 *  	- return 0
 *  - create 2 variables
 *  	- currentIndex
 *      - profit, the max profit we can gain
 *
 *  - while currentIndex < prices.length
 *  	 - find the smallest price than current index
 *  	   - while currentIndex < prices.length - 1 && prices[currentIndex+1] < prices[currentIndex]
 *  	   		- increment currentIndex
 *  	 - find the next greater prices for sale
 *  	 	- create variable minPrice and set valley = prices[currentIndex]
 *  	    - while currentIndex < prices.length - 1 && price[currentIndex+1] > prices[currentIndex]
 *  	    	- increment currentIndex
 *  	 - increment profit by prices[currentIndex] - minPrice
 *  	 - increment currentIndex
 *  return profit;
 *
 *
 */
public class MaxProfitBuySellStock1 {

	static int maxProfit(int[] prices){
		if (prices == null || prices.length == 0) return 0;
		int currentIndex = 0, profit = 0;
		while(currentIndex < prices.length){
			while ( currentIndex != prices.length - 1 && prices[currentIndex+1] <= prices[currentIndex]) currentIndex++;

			int minPrice = prices[currentIndex];

			while(currentIndex != prices.length - 1 && prices[currentIndex+1] >= prices[currentIndex]) currentIndex++;

			profit += prices[currentIndex] - minPrice;
			currentIndex++;
		}
		return profit;
	}
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println("Max Profit -> " + maxProfit(prices));
	}
}
