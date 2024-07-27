class Solution {
    public int maxProfit(int k, int[] prices) {
        // Tc: O(nk) Sc: O(k)
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] dp = new int[k + 1];
        int[] minPrices = new int[k + 1];
        for (int j = 0; j <= k; j++) {
            minPrices[j] = prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                minPrices[j] = Math.min(minPrices[j], prices[i] - dp[j - 1]);
                dp[j] = Math.max(dp[j], prices[i] - minPrices[j]);
            }
        }

        return dp[k];
    }
}