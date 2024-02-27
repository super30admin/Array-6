// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       if(n < 2)
        return 0;
       int[] buy = new int[n];
       int[] sell = new int[n];
       buy[0] = -prices[0];
       buy[1] = Math.max(buy[0],-prices[1]);
       sell[1] = Math.max(0,prices[1]+buy[0]);
       for(int i = 2; i < prices.length; i++){
           sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
           buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
       }
       return sell[n-1];
    }
}