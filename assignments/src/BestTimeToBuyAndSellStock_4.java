// Approach: DP
// Time: O(nk)
// Space: O(nk)

import java.util.Arrays;

class BestTimeToBuyAndSellStock_4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        buy[0] = prices[0];     // buy1

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], price - sell[j - 1]);   // buy2 = Min(buy2, price - sell1)
                sell[j] = Math.max(sell[j], price - buy[j]);    // sell2 = Max(sell2, price - buy2)
            }
        }
        return sell[k];
    }
}