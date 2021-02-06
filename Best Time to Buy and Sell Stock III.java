// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//similar to buy sell stock 1, keep track of min price and update profit = max(profit, prices[i]-min);
//to account for the second transaction possible that day, minCost of the same stock that day would be prices[i]-profit1

class Solution {
    public int maxProfit(int[] prices) {
      if(prices==null || prices.length<=1)
          return 0;
        
      int t1MinCost = prices[0], t2MinCost = prices[0];
      int t1Profit = 0, t2Profit = 0;
  
      for (int i=1; i<prices.length; i++) {
          t1MinCost = Math.min(t1MinCost, prices[i]);
          // the maximum profit if only one transaction is allowed
          t1Profit = Math.max(t1Profit, prices[i] - t1MinCost);
          
          // reinvest the gained profit in the second transaction
          t2MinCost = Math.min(t2MinCost, prices[i] - t1Profit);
          t2Profit = Math.max(t2Profit, prices[i] - t2MinCost);
      }
  
      return t2Profit;
    }
  }