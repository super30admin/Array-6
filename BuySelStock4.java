/**
 * Time Complexity:  O(nk)  where n is the length of the array, k is the number of transactions
 * Space Complexity: O(k) where k is the number of transactions
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, prices[0]);
        int result = 0;
        if (k >= prices.length / 2) {// any number of transactions like buy and sell 2 problem.
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    result += prices[i + 1] - prices[i];
                }
            }
            return result;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }

        return sell[k];
    }
}