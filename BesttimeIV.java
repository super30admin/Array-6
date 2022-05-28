// Time Complexity : O(NK)   
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using min and max concepts using the arrays
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k ==0)return 0;
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int i =0; i<prices.length; i++){
            for(int j =0; j<k; j++){
                if(j==0){
                    buy[j] = Math.min(buy[j], prices[i]);
                }
                else{
                    buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                }
                sell[j] = Math.max(sell[j] , prices[i] - buy[j]);
            }
        }
        return sell[k-1];
    }
}