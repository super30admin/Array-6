// Time Complexity : O(n) where n is the length of the array prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class buySellStock3 {
    public int maxProfit(int[] prices) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = 0, max2 = 0;
        for (int price : prices) {
            min1 = Math.min(min1, price);
            max1 = Math.max(max1, price - min1);
            min2 = Math.min(min2, price - max1);
            max2 = Math.max(max2, price - min2);
        }
        return max2;
    }
}