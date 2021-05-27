class BuyAndSellStockAtBestTimeWithCooldown {
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int n = prices.length;
        int[] buy = new int[n+1];
        int[] profit = new int[n+1];
        
        buy[1] = prices[0];
        profit[1] = 0;
        
        for(int i = 2; i <= n; i++){
            int price = prices[i-1];        // i-1 --> considering the index offset compared to the prices array
            
            buy[i] = Math.min(buy[i-1], price - profit[i-2]);
            profit[i] = Math.max(profit[i-1], price - buy[i]);
        }
        
        return profit[n];
    }
}