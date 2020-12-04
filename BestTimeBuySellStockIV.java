// Time Complexity : O(n*k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        
        k = k % prices.length;
        
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        int[] profit = new int[k+1];
        
        for(int price : prices){
            for(int j=1; j<=k; j++){
                buy[j] = Math.min(buy[j], price - profit[j-1]);
                profit[j] = Math.max(profit[j], price - buy[j]);
            }
        }
        
        return profit[k];
    }
        
}
