// Time Complexity : O(N*k)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(k > prices.length/2) {
            int maxProfit=0;
            for(int i=1;i<prices.length;i++) {
                if(prices[i] > prices[i-1])
                    maxProfit+=(prices[i]-prices[i-1]);
            }
            return maxProfit;
        } else {
            
        int buyingPrice[]=new int[k+1];
        Arrays.fill(buyingPrice, Integer.MAX_VALUE);
        int profit[]=new int[k+1];
            
        for(int price : prices) {
            for(int i=1;i<=k;i++) {
            buyingPrice[i]=Math.min(buyingPrice[i], price-profit[i-1]);
            profit[i]=Math.max(profit[i], price-buyingPrice[i]);
            
            }
        }
        return profit[k];
        }
    }

}

