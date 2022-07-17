public class ThirdBuySell {
    // TC : O(n)
    // SC : O(1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        // Min buying price seen until now
        int buy1 = Integer.MAX_VALUE;

        // Profit if only 1 transaction made
        int sell1 = Integer.MIN_VALUE;

        // Effective buying price after making a profit from the previous transaction
        int buy2 = Integer.MAX_VALUE;

        int sell2 = Integer.MIN_VALUE;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2, price - buy2);
        }

        return sell2;
    }
}
