// Time Complexity : O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class BuyAndSellStockI {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int result = 0;
        int buyIdx = 0; int sellIdx = 0;
        for(int i=1;i<prices.length; i++){
            if(buy > prices[i]){
                buy = prices[i];
                buyIdx = i;
            }
            if(result < prices[i]-buy){
                result = prices[i] - buy;
                sellIdx = i;
            }
        }
        System.out.println(buyIdx +" "+sellIdx);
        return result;
    }
}

