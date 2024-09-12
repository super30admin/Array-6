// Time Complexity : O(n) 
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE; // minimize
        int profit = 0; // maximize

        for(int price: prices) {
        	buyingPrice = Math.min(buyingPrice, price);
        	profit = Math.max(profit, price - buyingPrice);
        }

        return profit;
    }
}