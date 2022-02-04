// Time Complexity  : O(n)
// Space Complexity : O(1)
class Solution {
    public int maxProfit(int[] prices) {
        
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        
        int profit1 = Integer.MIN_VALUE;
        int profit2 = Integer.MIN_VALUE;
        
        // Iterate through each element
        for (int i = 0; i < prices.length ; i++){
            
            // lowest price considered as the buying stock 
            buy1 = Math.min(buy1, prices[i]);
            
            // Profit earned
            profit1 = Math.max(profit1, prices[i] - buy1);
            
            // Invest again using the profit1 to buy the second stock
            buy2 = Math.min(buy2, prices[i] - profit1);
            
            // Profit earned
            profit2 = Math.max(profit2, prices[i] - buy2);
        
        }
        
        return profit2;
            
    }
}