## Problem1: Buy and Sell Stock at Best Time (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

In this our approach is we want to find maximum maxProfit. So we will maintain 2 variables 
1. min = which will hold the minimum value
2. max = which will hold profit i.e maximum profit

Time Complexity : O(n)
Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        //base condition
        if(prices==null || prices.length<2){
            return 0;
        }
        //initialized min and max = 0 because if there is no profit then we can return 0 directly
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            //This will hold the minimum value
            min = Math.min(min,prices[i]);
            //This will hold the profit which will be maximum of previous profit or current element - min
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}