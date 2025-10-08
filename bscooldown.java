//TC: O(n): single pass over the price array with O(1) work per day.
//SC: O(1)

//Initialize base states for day 0 and day 1 (best buy/sell so far).
//For each day i ≥ 2: update buy as max(keep holding, buy after cooldown via prevSell - price) and sell as max(keep not holding, sell today using previous buy).
//Roll the window (prev ← curr) and finally return currSell as the maximum profit.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;

        int prevBuy = -prices[0];
        int prevSell = 0;

        int currBuy = Math.max(-prices[0], -prices[1]);
        int currSell = Math.max(prevSell, prevBuy + prices[1]);

        for(int i=2; i<n; i++){
            int tempBuy = currBuy, tempSell = currSell;

            currBuy = Math.max(currBuy, prevSell - prices[i]);
            currSell = Math.max(currSell, tempBuy + prices[i]);

            prevBuy = tempBuy;
            prevSell = tempSell;
        }

        return currSell;
    }
}
