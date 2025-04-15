// TC: O(n*k)
// SC: O(k)

import java.util.*;
public class LC188 {
    public int maxProfit(int k, int[] prices) {
        int buy[] = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int sell[] = new int[k+1];
        for(int price: prices){
            for(int i=1;i<=k;i++){
                buy[i] = Math.min(buy[i], price-sell[i-1]);
                sell[i] = Math.max(sell[i], price-buy[i]);
            }
        }
        return sell[k];
    }
}
