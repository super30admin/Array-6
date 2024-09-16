// Time Complexity : O(n) where n is the length of the array prices
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class buySellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
        	// question becomes same as part 2
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    max += prices[i] - prices[i-1];
                }
            }
            return max;
        }
        int[] min = new int[k+1];
        int[] max = new int[k+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                min[i] = Math.min(min[i], price - max[i-1]);
                max[i] = Math.max(max[i], price - min[i]);
            }
        }
        return max[k];
    }
}