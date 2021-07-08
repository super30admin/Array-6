// Time Complexity : O(nk) where n is the number of prices and k is the number of transactions
// Space Complexity : O(n) where buy and sell arrays maintain the previous transactions
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: if k exceeds n/2 implies every transaction is profitable if prices becomes larger than
the previous price. if k < n/2 then , we maintain the array of previous buy and sell where we keep track on previous buy's (keeping the min effective
price) and having the max sell price by subtracting the min buy[i] at each instance.
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
     if(prices == null) return 0;
     int n = prices.length;
     int sum = 0;
     if(k > n/2){                                                                                       // k exceeds array size
         for(int i  = 1; i < n; i++){
             if(prices[i] > prices[i-1]){
                 int share = prices[i] - prices[i-1];                                                   // every transaction is profitable
                 sum += share;
             }
         }  
         return sum;                                                                            // return the profit earned
     }
    int[] buy = new int[k+1];                                                                       // Keep track of previous min buys at diff prices
    Arrays.fill(buy, Integer.MAX_VALUE);        
    int[] sell = new int[k+1];                                                                  // Keep track of previous max profit's at diff prices
    for(int price : prices){
        for(int i = 1; i <= k; i++){
            buy[i] = Math.min(buy[i], price - sell[i-1]);                                                   // Min buy at ith transaction at each price
            sell[i] = Math.max(sell[i], price - buy[i]);                                                    // Max sell at ith transaction at each price
        }
    }
    return sell[k];                                                                                     // Max profit sold at kth transaction
    }
}