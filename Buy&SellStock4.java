// Time Complexity : O(n) --> where n is the number of elements in the input array
// Space Complexity : O(k) --> where k is the given inout
// Did this code successfully run on Leetcode (188): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int k, int[] prices) {
        // edge case
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }                
            }
            return profit;
        }
        
        int buy[] = new int[k+1];
        int sell[] = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.min(buy[i], price - sell[i-1]);
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k];
    }
}