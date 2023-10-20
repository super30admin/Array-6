// Time Complexity : O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class BuyAndSellStockIII {
    public int maxProfit(int[] prices) {

        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;

        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        //System.out.println("Buy1"+" "+"Profit1"+" "+"Buy2"+" "+"Profit2");

        for (int i = 0; i < prices.length; i++) {


            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);

            buy2 = Math.min(buy2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buy2);

            // System.out.println(buy1+"        "+profit1+"     "+buy2+"     "+profit2);

        }

        return profit2;
    }
}