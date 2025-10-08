//TC: O(n*k): iterate days (n) × transactions (k), O(1) work per state.
//SC: O(n*k): 3D DP table of size n×2×(k+1).

//dp[i][0][t] = best profit on day i holding a stock with up to t transactions; dp[i][1][t] = best profit not holding a stock.
//Transitions: dp[i][0][t]=max(dp[i-1][0][t], dp[i-1][1][t-1]-prices[i]); dp[i][1][t]=max(dp[i-1][1][t], dp[i-1][0][t]+prices[i]); base: dp[0][0][t]=-prices[0], dp[0][1][t]=0.
//Answer: dp[n-1][1][k] (max profit after at most k transactions, ending with no stock).

class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        int n = prices.length;
        if (n == 0) return 0;

        int[][][] dp = new int[n][2][k + 1];

        for (int t = 0; t <= k; t++){
            dp[0][0][t] = -prices[0]; 
            dp[0][1][t] = 0;         
        }

        for (int i = 1; i < n; i++){
            for (int t = 1; t <= k; t++){
                dp[i][0][t] = Math.max(dp[i - 1][0][t], dp[i - 1][1][t - 1] - prices[i]);
                dp[i][1][t] = Math.max(dp[i - 1][1][t], dp[i - 1][0][t] + prices[i]);
           }
        }

        return dp[n - 1][1][k];
    }
}
