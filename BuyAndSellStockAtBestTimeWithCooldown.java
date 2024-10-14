//TC = O(n)
//SC = O(1)
class BuyAndSellStockAtBestTimeWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int currBuy = Math.max(-prices[0], -prices[1]);
        int prevSell = 0;
        int currSell = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++) {
            int temp = currSell;
            currSell = Math.max(currSell, prices[i] + currBuy);
            currBuy =  Math.max(currBuy, -prices[i] + prevSell);
            prevSell = temp;
        }
        return currSell;
    }
}