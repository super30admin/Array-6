class BuyAndSellStockAtBestTimeIV {
    
    // Time Complexity: O(nk)
    // Space Complexity: O(k) -- O(2k)
    
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        int[] profit = new int[k+1];
        Arrays.fill(profit, 0);
        
        for(int price : prices){
            for(int j = 1; j <= k; j++){
                buy[j] = Math.min(buy[j], price - profit[j-1]);
                profit[j] = Math.max(profit[j], price - buy[j]);
            }
        }
        return profit[k];
    }
}