// Time Complexity : O(n * k)
// Space Complexity : O(n * k)
// Method used : DP

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k * 2 + 1];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int buy = 1; buy <= 2; buy++)
            {
                for(int count = k * 2 - 1; count >= 0; count--)
                {
                    if(buy == 1) dp[i][1][count] = Math.max(-prices[i] + dp[i + 1][0][count + 1], dp[i + 1][1][count]);

                    else dp[i][0][count] = Math.max(prices[i] + dp[i + 1][1][count + 1], dp[i + 1][0][count]);
                }
            }
        }

        return dp[0][1][0];
    }
}