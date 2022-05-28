// Time Complexity : O(n*k) where n is the length of prices array and k is the max txn allowed
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This is similar to best time to buy 3
// Here instead of 2, k txns are allowed, so we will take array of buy and profit
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length < 1)
            return 0;
        int[] buy = new int[k+1];
        int[] profit = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int x: prices){
            for(int i = 0; i < k; i++){
                if(i == 0)
                    buy[i] = Math.min(buy[i], x);
                else
                    buy[i] = Math.min(buy[i], x - profit[i-1]);
                profit[i] = Math.max(profit[i], x-buy[i]);
            }
        }
        return profit[k-1];
    }
}