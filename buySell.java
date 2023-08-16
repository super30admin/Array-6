// TC: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int iBuy =0 ;
        int n= prices.length;
        int max=0;
        for(int i=0; i<n; i++){
            if(prices[i]<prices[iBuy])
                iBuy= i;
            max = Math.max(max, prices[i]-prices[iBuy]);
        }

        return max;
    }
}
