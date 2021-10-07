// Time Complexity : O(n), n -> Length of prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

public class BestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int buy1 = Integer.MAX_VALUE;
		int buy2 = Integer.MAX_VALUE;
		int sell1 = 0;
		int sell2 = 0;

		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.min(buy1, prices[i]);
			sell1 = Math.max(sell1, prices[i] - buy1);

			buy2 = Math.min(buy2, prices[i] - sell1);
			sell2 = Math.max(sell2, prices[i] - buy2);
		}
		return sell2;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 obj = new BestTimeToBuyAndSellStock3();
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };

		System.out.println("Maximum profit: " + obj.maxProfit(prices));
	}

}
