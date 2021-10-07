// Time Complexity : O(n * k), n -> Length of prices, k -> Maximum transactions
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem4;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0 || k == 0) {
			return 0;
		}

		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];

		Arrays.fill(buy, Integer.MAX_VALUE);

		for (int i = 0; i < prices.length; i++) {
			for (int j = 1; j <= k; j++) {
				buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
				sell[j] = Math.max(sell[j], prices[i] - buy[j]);
			}
		}
		return sell[k];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock4 obj = new BestTimeToBuyAndSellStock4();
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int k = 2;
		System.out.println("Maximum profit: " + obj.maxProfit(k, prices));
	}

}
