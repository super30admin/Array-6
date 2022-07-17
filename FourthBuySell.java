import java.util.Arrays;

public class FourthBuySell {
    // This is an extension to Buy and sell stock III
    // TC : O(n * k)
    // SC : O(1)
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices == null || prices.length == 0) return 0;

        int[] buy = new int[k];
        int[] sell = new int[k];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int j = 0; j < k; j++) {
                if (j > 0) { // to avoid array index out of bound
                    buy[j] = Math.min(buy[j], price - sell[j - 1]);
                } else {
                    buy[j] = Math.min(buy[j], price);
                }
                sell[j] = Math.max(sell[j], price - buy[j]);
            }
        }

        return sell[k - 1];
    }
}
