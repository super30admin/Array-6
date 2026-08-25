//Time Complexity O(n)
//Space Complexity O(1)
public class MaxProfitCoolDown {
    int[][] dp;
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        int currBuy = Math.max(-prices[0], -prices[1]);
        int currSell = Math.max(0, prices[1] - prices[0]);
        int prevSell = 0;

        for(int i = 2; i < prices.length; i++) {
            int temp = currSell;
            currBuy = Math.max(currBuy, prevSell - prices[i]);
            currSell = Math.max(currSell, prices[i]+currBuy);
            prevSell = temp;
        }
        return currSell;
    }
}
