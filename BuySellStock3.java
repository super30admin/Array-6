/****
 * Uses 4-state greedy DP to track two buy/sell transactions in one pass.
 * Updates best profit by maintaining effective buy prices adjusted by previous profits.
 * Time: O(n), Space: O(1)
 */
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buy1 = prices[0], buy2 = prices[0];
        int sell1 = 0, sell2 = 0;

        for(int i=1; i<n; i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1); 

            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
}
