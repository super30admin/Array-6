// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int maxProfit(int[] prices) {
        //Min number at that point
        int min = prices[0];
        int result = 0;

        //go through all the numbers and calculate profit
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }

        return result;
    }
}