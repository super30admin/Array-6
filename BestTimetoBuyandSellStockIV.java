// Time Complexity :  O(n*k)
// Space Complexity : O(n*k) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BestTimetoBuyandSellStockIV {
        int n;
        Integer[][][] dp;
        public int maxProfit(int k, int[] prices) {
            n = prices.length;
            dp = new Integer[n][2][k+1];
            return helper(0, 0, k, k, prices);
        }
    
        private int helper(int idx, int buying, int tran, int k , int[] prices){
    
            if (idx >= n) return 0;
            if (tran == 0) return 0;
            if (dp[idx][buying][tran] != null) return dp[idx][buying][tran];
    
            if (buying == 0){
                int buy = helper(idx+1, 1, tran, k, prices) - prices[idx];
                int dontbuy = helper(idx+1, 0, tran, k, prices);
                dp[idx][buying][tran] = Math.max(buy, dontbuy);
            } else {
                int sell = helper(idx+1, 0, tran-1, k, prices) + prices[idx];
                int dontsell = helper(idx+1, 1, tran, k, prices);
                dp[idx][buying][tran] = Math.max(sell, dontsell);
            }
            return dp[idx][buying][tran];
        }
    }