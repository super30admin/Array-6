## Problem2: Buy and Sell Stock at Best Time III (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

// This is same as that of Buy and sell stock 1 question just the difference is here we can buy and sell twice 
// So we will have the same approach but just maintaining buy1, sell1,buy2,sell2 
// buy1 is the price to buy stock 1
// sell1 is the profit by selling stock 1
// buy2 is the buy value of the stocka nd we are subtracting the previous transaction profit from it
// sell2 is the final profit after both the transaction

// There is no cap that we should have 2 transactions only there can be one transaction on;y and it can give max profit

// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length < 2){
            return 0;
        }
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for(int i=0;i< prices.length;i++){
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i]-sell1);
            sell2 = Math.max(sell2, prices[i]-buy2);
        }

        return sell2;
    }
}