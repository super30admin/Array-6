// Time Complexity : O(len(prices)) 
// Space Complexity : O(k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            
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