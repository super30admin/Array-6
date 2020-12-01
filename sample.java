// Best Time to Buy and Sell Stock
// Time Complexity: O(n) where n = number of elements in array
// Space Complexity: O(1) no extra space 

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // initializing buy and profit
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        // looping over prices
        for (int price : prices) {
            // if price is less than curr buy, then change buy
            if (price < buy) {
                buy = price;
            }
            // if price - buy is greater than profit, then change profit
            if (price - buy > profit) {
                profit = price - buy;
            }
        }
        
        return profit;
    }
}
