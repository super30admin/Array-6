// Time Complexity : O(n) --> where n is the number of elements in the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (121): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int[] prices) {
        // edge case
        if (prices == null || prices.length == 0) return 0;
              
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}