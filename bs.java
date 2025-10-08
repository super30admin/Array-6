//TC: O(n): single pass over prices.
//SC: O(1): constant variables (currBuy, currSell, tempBuy).

//Initialize currBuy = -prices[0] and currSell = 0 to represent best buy value and best profit.
//For each price: tempBuy = currBuy; update currBuy = max(currBuy, -price) (cheapest buy), and currSell = max(currSell, tempBuy + price) (best profit).
//Return currSell as the maximum profit with one transaction.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int currBuy = -prices[0];
        int currSell = 0;

        for(int i=1; i<n; i++){
            int tempBuy = currBuy;
            currBuy = Math.max(currBuy,  - prices[i]);
            currSell = Math.max(currSell, tempBuy + prices[i]); 
        }

        return currSell;
    }
}
