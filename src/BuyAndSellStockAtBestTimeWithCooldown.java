//time complexity- O(n)
//space complexity- o(n)
import java.util.*;
public class BuyAndSellStockAtBestTimeWithCooldown {
    static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
        for(int i=2; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[n-1][1];
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println("Prices: "+ Arrays.toString(prices));
        System.out.println("Maximum Profit: "+ maxProfit(prices));
    }
}
