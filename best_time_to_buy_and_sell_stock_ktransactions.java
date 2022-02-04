// Time complexity : O(n) - Iterate through all the prices
// space complexity : O(k) - Store buy and profit for k transactions 

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        // no transactions
        if (k == 0){
            return 0; // no profit
        }
        
        // buy array of k size mapping to k transactions
        int[] buy = new int[k];
        
        // profit array of k size mapping to k transactions
        int[] profit = new int[k];
        
        
        // Initialise the arrays
        for (int i = 0; i < k; i++){

            buy[i] = Integer.MAX_VALUE;
            profit[i] = 0;

        }
        
        // Iterate through each price of the stock
        for (int i = 0; i < prices.length; i++){
            
             // Update the buy array and price array
            for (int j = 0; j < k; j++){
                
                if (j == 0){
                    
                    buy[j] = Math.min(buy[j], prices[i]);
                }
                else{
                    
                    buy[j] = Math.min(buy[j], prices[i] - profit[j-1]);
                }
                
                // Profit earned
                profit[j] = Math.max(profit[j] , prices[i] - buy[j]);
            }
        }
       
       // The last profit value will contain the atmost k transactions profit
       return profit[k-1]; 
    }
}