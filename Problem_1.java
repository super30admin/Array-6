// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the min or start by comparing each and also calculate result by taking max of result and differnce of min and current value.

// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result,prices[i]-min);
        }
        return result;
    }
}