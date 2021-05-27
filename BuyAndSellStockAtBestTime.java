class BuyAndSellStockAtBestTime {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        
        return profit;
    }
}