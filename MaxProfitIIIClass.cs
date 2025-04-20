// TC = O(n)
// SC = O(1)
public class Solution {
    public int MaxProfit(int[] prices) {
        if(prices == null || prices.Length == 0){
            return 0;
        }

        int buy1 = Int32.MaxValue, sell1 = 0, buy2 = Int32.MaxValue, sell2 = 0;
        for(int i = 0; i< prices.Length; i++){
            buy1 = Math.Min(buy1, prices[i]);
            sell1 = Math.Max(sell1, prices[i] - buy1);

            buy2 = Math.Min(buy2, prices[i] - sell1);
            sell2 = Math.Max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
}