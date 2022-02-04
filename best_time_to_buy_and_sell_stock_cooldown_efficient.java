// Efficient DP approach
// Time Complexity : O(n)
// Space Complexity : O(n) : DP array

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1){
            
            return 0;
        }
        
        int[] dpBuy =  new int[prices.length];
        int[] dpSell =  new int[prices.length];
        
        // Initialise first two columns
        dpBuy[0] = -prices[0]; 
        // not buy case and buy case 
        dpBuy[1] = Math.max(dpBuy[0] , -prices[1]);
        
        dpSell[0] = 0; // no profit
        // not sell case and sell case : previous buy net profit + present price
        dpSell[1] = Math.max(dpSell[0] , prices[1] + dpBuy[0] );
        
        // Update the values in dpbuy and dpsell array
        for (int i = 2; i < prices.length; i++ ){
            
            // buy case and not buy case
            dpBuy[i] = Math.max(dpBuy[i-1] , dpSell[i - 2] - prices[i]);
            
             // sell case and not sell case
            dpSell[i] = Math.max(dpSell[i-1] , dpBuy[i - 1] + prices[i]);
            
        }
        
        
        return dpSell[prices.length - 1];
    }
    

}