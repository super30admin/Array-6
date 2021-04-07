//TC:O(N)
//SC:O(1)
//Dit it run successfully on Leetcode? : Yes
class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      int min = Integer.MAX_VALUE;
      for ( int i = 0; i < prices.length; i++)
      {
         // calculate min
         min = Math.min(min,prices[i]);
            
         // calculate prices[i] - min and update maxProfit if it is greater than maxProfit 
         maxProfit = Math.max(maxProfit, prices[i] - min);             
      }
        return maxProfit;
    }
}

