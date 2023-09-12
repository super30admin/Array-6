// time complex : O(n)
// space complex : O(n)

// problem link  : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[] dp = new int[n];
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        int maxPrice = prices[n - 1];
        int maxProfit = dp[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i] + dp[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        return maxProfit;
    }
}
