// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int maxProfit(int[] prices) {
      if(prices==null || prices.length==0)
          return 0;
        
      int[] maxProfit = new int[prices.length + 2];
  
      for (int i=prices.length-1; i>= 0; i--) {
        int c1 = 0;
          
        // Case 1. buy and sell the stock
        for (int j=i+1; j<prices.length; j++) {
          int profit = (prices[j] - prices[i]) + maxProfit[j + 2];
          c1 = Math.max(profit, c1);
        }
  
        // Case 2. do no transaction with the stock p[i]
        int c2 = maxProfit[i + 1];
  
        // wrap up the two cases
        maxProfit[i] = Math.max(c1, c2);
      }
        
      return maxProfit[0];
    }
  }