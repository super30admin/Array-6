// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        
        int buy1 = Integer.MAX_VALUE;
        int profit1 =0;
        
        int buy2 = Integer.MAX_VALUE;
        int profit2 =0;
        
        for(int price : prices){
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        
        return profit2;         
    }
}
