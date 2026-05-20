/**
 * Finds maximum profit from a single buy-sell transaction using one pass.
 * Tracks minimum price so far and updates best profit greedily at each step.
 * Time Complexity: O(n), Space Complexity: O(1).
 */
public class BuySellStock1 {
        public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null || prices.length < 2) {
            return maxProfit;
        }
        int minPrice = Integer.MAX_VALUE; 

        for(int i : prices) {
            minPrice = Math.min(minPrice, i);
            maxProfit = Math.max(maxProfit, i-minPrice);
        }
        return maxProfit;
    }
    
}
