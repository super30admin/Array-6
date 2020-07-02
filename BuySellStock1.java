// 121.
// brute force - try to buy on each day i from 0 to n - 1 and sell at all possible days j from i + 1 to n - 1 
// return the max profit to get a run time of O(n^2)
// time - O(n)
// space - constant
class Solution {
    public int maxProfit(int[] prices) {
        //edge
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        
        //try to sell at each at day and buy at a day previous to current day and has min price so far
        int min = Integer.MAX_VALUE; // tracks the min price to the left of current price
        int profit = 0; //return value - initially 0
        for(int price : prices)
        {
            //update min with min(lowest price so far, current price)
            min = Math.min(min, price);
            //sell at this day (buy occurs at day when min happened) - update max profit if needed
            profit = Math.max(profit, price - min); 
        }
        
        return profit;
    }
}
