// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;
        
        // Iterate through each element
        for (int i =0; i < prices.length ; i++){
            
            // Store the buy with the lowest price 
            buy = Math.min(buy, prices[i]);
            
            // Store the max profit based on the latest buy
            profit = Math.max(profit , prices[i] - buy);
            
        }
        
        return profit;
        
    }
}