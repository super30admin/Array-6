//time complexity- O(nk)
//space complexity- o(k)
import java.util.*;
public class BuyAndSellStockAtBestTime4 {
    static int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, prices[0]);
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println("Prices: "+ Arrays.toString(prices));
        System.out.println("Maximum Profit: "+ maxProfit(k, prices));
    }
}
