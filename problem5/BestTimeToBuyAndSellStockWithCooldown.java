// Time Complexity : O(n), n -> Length of prices
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem5;

public class BestTimeToBuyAndSellStockWithCooldown {
	/********************* Brute Force *********************/
	// Time Complexity : O(n), n -> Length of prices
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Timelimit Exceeded
	// Any problem you faced while coding this : No
	public int maxProfitRecursion(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		return helper(prices, 0, 0, -1);
	}

	private int helper(int[] prices, int index, int profit, int prevBuyRate) {
		// Base
		if (index >= prices.length) {
			return profit;
		}
		// Logic
		if (prevBuyRate == -1) {
			// buy
			int buy = helper(prices, index + 1, profit, prices[index]);
			// Don't buy
			int dontBuy = helper(prices, index + 1, profit, prevBuyRate);

			return Math.max(buy, dontBuy);
		} else {
			// Sell
			int sell = helper(prices, index + 2, profit + prices[index] - prevBuyRate, -1);
			// Don't Sell
			int dontSell = helper(prices, index + 1, profit, prevBuyRate);
			return Math.max(sell, dontSell);
		}
	}

	/********************* Optimized *********************/
	// Time Complexity : O(n), n -> Length of prices
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Timelimit Exceeded
	// Any problem you faced while coding this : No
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];

		buy[0] = -prices[0];
		buy[1] = Math.max(buy[0], -prices[1]);
		sell[1] = Math.max(sell[0], prices[1] + buy[0]);

		for (int i = 2; i < n; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}

		return sell[n - 1];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithCooldown obj = new BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println("Maximum profit: " + obj.maxProfit(prices));
	}

}
