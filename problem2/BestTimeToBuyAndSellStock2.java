// Time Complexity : O(n), n -> Length of prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class BestTimeToBuyAndSellStock2 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int ans = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				ans += prices[i] - prices[i - 1];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 obj = new BestTimeToBuyAndSellStock2();
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println("Maximum profit: " + obj.maxProfit(prices));
	}

}
