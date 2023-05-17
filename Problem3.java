/*
Buy and Sell Stock at Best Time IV
approach: similar to iii, but we have to check only previous min or max
time: O(nxk)
space: O(nxk)
 */
import java.util.Arrays;
public class Problem3 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for(int i=0;i<n;i++) {
            for(int j=1;j<=k;j++) {
                buy[j] = Math.min(buy[j], prices[i]-sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i]-buy[j]);
            }
        }
        return sell[k];
    }
}
