// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class BestTimeToBuyAndSellStocksWithCoolDown {

    public int maxProfit(int[] prices) {
        //null case
        if(prices == null || prices.length < 2) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0],0 - prices[1]); // 0 coz there is no 2 steps before
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for(int i= 2; i < prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]); // cool down period
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return Math.max(buy[prices.length - 1], sell[prices.length - 1]);
    }
}
