class BestTimeToBuyStocks1 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
        }
    return maxProfit;
    }
}