// Time Complexity : O(n) --> where n is the number of elements in the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (123): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0; int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            // effective prices going forward
            buy2 = Math.min(buy2, price - sell1); // included the profit from 1st transaction if any in this
            sell2 = Math.max(sell2, price - buy2);
        }
        return sell2;
    }
}