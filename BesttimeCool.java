// Time Complexity : O(N)   
// Space Complexity : O()
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using dp
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int sold = Integer.MIN_VALUE;
        int reset = 0;
        int held  = Integer.MIN_VALUE;
        for(int price : prices){
            int presold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, presold);
        }
        return Math.max(sold, reset);
    }
}