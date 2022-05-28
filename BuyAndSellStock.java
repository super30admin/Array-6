// Time Complexity : O(n) where in is the length of prices array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We keep the min count of the stock price till current pointer
// If the current price is greater than the price we encountered previously
// We will get the difference and store the profit if its greater than the previous 
// profit value. Finally we will return the profit value.
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];   
            else
                profit = Math.max((prices[i] - min), profit);
        }
        return profit;
    }
}