// Time Complexity : O(2^n) (two cases for each : buy state/sell state )
// Space Complexity : O(n) : Recursive Stack : not buy for each price 

class Solution {
    public int maxProfit(int[] prices) {
        
        // Initial buyindex is -1
        return helper(prices, 0, -1);
    }
    
    
    // buyindex : -1 not bought, i : index that we bought
    
    private int helper(int[] prices, int index, int buyindex){
        
        // edge case 
        if (index >= prices.length){
            
            return 0;
        }
        
        // buy case
        if (buyindex == -1){
            // not bought case
            int notbuy = helper(prices, index + 1, buyindex);
                
            // buyindex maps to the bought index
            int buy = helper(prices, index + 1, index );
                
            return Math.max(notbuy, buy);
            
        }
        
        // sell case
        else{
            
            // not bought case
            int notSell = helper(prices, index + 1, buyindex);
                
            // If sold, index should be index + 2 as it needs cooldown period and buyindex will be -1. It will be restarted.
            int sell = prices[index] - prices[buyindex] + helper(prices, index + 2, -1);
                
            return Math.max(notSell, sell);
            
        }
        
    }
}