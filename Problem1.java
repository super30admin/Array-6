/*
The best profit can be earned by buy a stock at a minimum price and selling it at a higher price

Intuition:

We will traverse through the array, and maintain a min amount throughout  
and at each point we will calculate the profit we can get by selling the stock
at that point (by subtracting the min with the amount that dayy) at the end we will return the max profit

Time: O(n)
Space: O(1)

*/

class Solution {
    public int maxProfit(int[] prices) {

        int profit =0;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit,prices[i] - min );
        }

        return profit;
        
    }
}