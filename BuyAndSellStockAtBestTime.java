// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We traverse the array and capture the buy to be at the minimum position possible as we have to make only one transaction. We
// track the profit at each index and capture the maximum and return it.

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for(int i = 1; i< prices.length;i++){
            if(prices[i] < buy){
                buy = prices[i]; //update the buy at lowest prices
            }
            max = Math.max(max, prices[i] - buy); //max profit at each day
        }
        return max;
    }
}