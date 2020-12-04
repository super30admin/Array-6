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

// Best Time to Buy and Sell Stock III
// Time Complexity: O(n) where n = number of elements in array
// Space Complexity: O(1) no extra space

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // initiliazing buy and profit for 2 transactions
        int buy1 = Integer.MAX_VALUE; int profit1 = 0;
        int buy2 = Integer.MAX_VALUE; int profit2 = 0;
        // loop over prices array
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        
        return profit2;
    }
}

// Best Time to Buy and Sell Stock IV
// Time Complexity: O(n * k) where n = number of elements in array and k = number of transactions
// Space Complexity: O(k) extra space for buy and profit

class Solution {
    public int maxProfit(int k, int[] prices) {
        // base condition
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // to handle k > prices.length / 2
        k = k % prices.length; 
        // initialize buy and profit array with length k + 1
        int[] buy = new int[k + 1];
        int[] profit = new int[k + 1];
        
        Arrays.fill(buy, Integer.MAX_VALUE);
        // loop over prices
        for (int price : prices) {
            // loop over buy and profit array
            for (int i=1; i<=k; i++) {
                // get buy
                buy[i] = Math.min(buy[i], price - profit[i - 1]);
                // get profit
                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }
        
        return profit[k];
    }
}
