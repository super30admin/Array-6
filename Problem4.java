/*
Buy and Sell Stock with cooldown
approach: same as all previous, here we have 4 options 1. skip buy 2. buy 3. skip sell 4. sell
time: O(n)
space: O(n)
 */
public class Problem4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) return 0;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], 0-prices[1]);
        sell[1] = Math.max(sell[0], buy[0]+prices[1]);
        for (int i=2;i<n;i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return Math.max(buy[n-1], sell[n-1]);
    }
}
