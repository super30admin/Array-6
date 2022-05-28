// Time Complexity : O(N)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using min and max concepts
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0)return 0;
        int low = prices[0], max = 0; 
        for(int i = 1 ; i< prices.length; i++){
            if(prices[i]<low){
                low = prices[i];
            }
            if(max<prices[i]-low){
                max = prices[i]-low;
            }
        }
        return max;
    }
}