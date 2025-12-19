/*
121. Best Time to Buy and Sell Stock
Ran on leetcode: Yes
TC: O(n) SC: O(1)
At each point in prices array look for the min stock price we have seen so far, using min calculate the profit and update max if it is the maximum profit we have seen so far.
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int maxProfit = 0; 

        for(int i = 1; i < prices.length; i++){ // Look for min and calculate max at each point in prices array
            min = Math.min(min, prices[i]); // Keep track of the min stock price we have seen so far
            maxProfit = Math.max(maxProfit, prices[i] - min); // Max profit using the min we have seen so far
        }

        return maxProfit;
    }
}