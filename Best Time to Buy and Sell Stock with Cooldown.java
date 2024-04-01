// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DP

class Solution {

    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;

        int[][]dp = new int[n + 2][2];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int buy = 1; buy <= 2; buy++)
            {
                if(buy == 1) dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);

                else dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
            }
        }

        return dp[0][1];
    }
}