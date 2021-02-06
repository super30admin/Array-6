// Time Complexity : O(nk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
//use logic from bes time to buy sell stock III, minSoFar[k] = Math.min(minSoFar[k], prices[i]-profit[k-1])
// similarly profit[k] = Math.max(profit[k], prices[i]-minSoFar[k])

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k==0 || prices==null || prices.length==0)
            return 0;
        
        int n = prices.length;
        if(k>=n/2){
            int profit = 0;
            for(int i=1; i<prices.length; i++){
                if(prices[i-1]<prices[i]){
                    profit += prices[i]-prices[i-1];
                }
            }
            return profit;
        }
        
        int[] minSoFar = new int[k+1];
        int[] maxProfit = new int[k+1];
        Arrays.fill(minSoFar, prices[0]); 
        
        for(int i=1; i<prices.length; i++){
            for(int j=1; j<=k; j++){
                minSoFar[j] = Math.min(minSoFar[j], prices[i]-maxProfit[j-1]);
                maxProfit[j] = Math.max(maxProfit[j], prices[i]-minSoFar[j]);
            }
        }
        
        return maxProfit[k];
    }
}