## Problem3: Buy and Sell Stock at Best Time IV (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

This question is same as that of previous question just the difference here is we are given k which gives k transactions.

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length == 0){
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy,Integer.MAX_VALUE);  //initializing it with infinity and we dont need to initialize sell[] as it is already 0
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<k;j++){
                if(j==0){
                    buy[j] = Math.min(buy[j],prices[i]);
                }
                else{
                    buy[j] = Math.min(buy[j],prices[i]-sell[j-1]);
                }
                sell[j]=Math.max(sell[j],prices[i]-buy[j]);
            }
        }
        return sell[k-1];
    }
}