// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Same as buy-sell with atmost 2 but we have to maintain the buy and sell array: where buy = min(buy[i-1], price[i]-sell[i-1]) and sell = max(sell[i-1], price[i]-buy[i]);
// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0) return 0;
        int [] b = new int [k];
        Arrays.fill(b, Integer.MAX_VALUE);
        int [] s = new int [k];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                if( j > 0){
                    b[j] = Math.min(b[j], prices[i]-s[j-1]);
                }else{
                    b[j] = Math.min(b[j], prices[i]);
                }
                s[j] = Math.max(s[j], prices[i]-b[j]);
            }
        }
        return s[k-1];
    }
}