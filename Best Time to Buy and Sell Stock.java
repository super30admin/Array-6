// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Greedy

class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0, min = prices[0];

        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] - min > profit) profit = prices[i] - min;

            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}