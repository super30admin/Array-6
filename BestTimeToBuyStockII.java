class BestTimeToBuyStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        for(int i=0; i< prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit = prices[i+1] - prices[i];
                maxProfit += profit;
            }
            
        }
        return maxProfit;
    }
}