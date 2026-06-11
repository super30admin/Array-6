// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We leverage dp 2-D array at first to store repeated subproblems solutions by checking 2 states(sell,buy) in
terms of holding or not for a stock. If we choose to buy a stock, we get the value from dp[i-2][1] since cooldown
needs to be considered and state change should have been previously at sell for us to buy now and then subtract
the current price of the stock.Similarly, if we want to sell, we would have got it from the dp[i-1][0] since
we can assume we might bought the previous price so state change should also be considered. At every stage,
maximum of choose and not choose should be considered for max profit. We optimize the space by replacing dp
array with variables and return the currSell value.
 */
class Solution {
    public int maxProfit(int[] prices) {
        //Optimized space
        int n = prices.length;
        if(n == 1)
            return 0;

        int prevBuy = -prices[0];
        int prevSell = 0;

        int currBuy = Math.max(-prices[0], -prices[1]);
        int currSell = Math.max(prevSell, prevBuy + prices[1]);

        for(int i = 2 ; i < n ; i++) {
            int tempBuy = currBuy;
            int tempSell = currSell;

            currBuy = Math.max(currBuy , prevSell - prices[i]);
            currSell = Math.max(currSell, tempBuy + prices[i]);

            prevBuy = tempBuy;
            prevSell = tempSell;
        }
        return currSell;
    }
}