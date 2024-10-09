// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]); // finding the cumulative profit
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }

        return sell[k];
    }
}