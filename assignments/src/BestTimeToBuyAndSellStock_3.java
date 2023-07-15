// Approach: One pass
// Idea: Reduce the 2nd transaction buy price effectively by subtracting the 1st transaction profit.
// Time: O(n)
// Space: O(1)

class BestTimeToBuyAndSellStock_3 {
    public int maxProfit(int[] prices) {
        int t1Buy = Integer.MAX_VALUE,
                t2Buy = Integer.MAX_VALUE;
        int t1Profit = 0,
                t2Profit = 0;

        for (int price : prices) {
            // Max profit if only 1 transaction is allowed
            t1Buy = Math.min(t1Buy, price);
            t1Profit = Math.max(t1Profit, price - t1Buy);

            // Reinventing the gained profit in the 2nd transaction -
            t2Buy = Math.min(t2Buy, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Buy);
        }
        return t2Profit;
    }
}