// time Complexity : O(n)
// Space Complexity: O(1)
public class BuyAndSellCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int prevSell = 0, prevBuy = -prices[0], prevPrevSell = 0;

        for (int i = 1; i < n; i++) {
            int temp = prevSell; // Store previous sell value before updating it

            int newBuy = Math.max(prevBuy, prevPrevSell - prices[i]);
            int newSell = Math.max(prevSell, prevBuy + prices[i]);

            prevPrevSell = temp; // Correctly update prevPrevSell
            prevBuy = newBuy;
            prevSell = newSell;
        }

        return prevSell;
    }

    public static void main(String[] args) {
        BuyAndSellCoolDown solution = new BuyAndSellCoolDown();

        int[] prices = {1, 2, 3, 0, 2};
        int result = solution.maxProfit(prices);
        System.out.println("Maximum profit achieved: " + result);
    }
}
