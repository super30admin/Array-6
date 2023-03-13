// Time Complexity :  O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;
public class BestTimetoBuyandSellStockwithCooldown {
        int n;
        int[][] dp;
        public int maxProfit(int[] prices) {
            n = prices.length;
            dp = new int[n][2];
            for (int[] d : dp){
                Arrays.fill(d, -1);
            }
            return helper(0,0, prices);
        }
    
        private int helper(int idx, int buying, int[] prices){
            if (idx >= n) return 0;
    
            if (dp[idx][buying] != -1) return  dp[idx][buying];
    
            if (buying == 0){
                int buy = helper(idx+1, 1, prices) - prices[idx];
                int cooldown = helper(idx+1, 0, prices);
                dp[idx][buying] = Math.max(buy, cooldown);
            } else {
                int sell = helper(idx+2, 0, prices) + prices[idx];
                int cooldown = helper(idx+1, 1, prices);
                dp[idx][buying] = Math.max(sell, cooldown);
            }
            return dp[idx][buying];
    
        }
    }