// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++) {
            
            for(int j = 0; j < k; j++) {
                if(j == 0) {
                    
                    buy[j] = Math.min(buy[j], prices[i]);
                    sell[j] = Math.max(sell[j], prices[i] - buy[j]);
                } else {
                    
                    buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                    sell[j] = Math.max(sell[j], prices[i] - buy[j]);
                }
            }
        }
        
        return sell[k - 1];
    }
}