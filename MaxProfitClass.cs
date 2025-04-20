// TC = O(n)
// SC = O(1)
public class Solution {
    public int MaxProfit(int[] prices) {
        if(prices == null || prices.Length == 0){
            return 0;
        }
        int buy = Int32.MaxValue, sell = 0;
        for(int i = 0; i < prices.Length; i++){
            buy = Math.Min(buy, prices[i]);
            sell = Math.Max(sell, prices[i] - buy);
        }
        return sell;
    }
}