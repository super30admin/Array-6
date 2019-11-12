/****
Time O(n)
Space O(1)
Leetcode yes
Problem no

We always chose the min price as purchase and keep on checking profit for each subsequent day. As and when we find a smaller price than our
previous min price we update our purchase price.
****/

class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i = 0 ; i< prices.length ; i++)
        {
            if(prices[i] < min)
                min = prices[i];
            
            profit = Math.max(profit, prices[i] - min );
        }
        
        return max;
    }
}
