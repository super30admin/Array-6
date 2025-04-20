// TC = O(nk)
// SC = O(k)
public class Solution {
    public int MaxProfit(int k, int[] prices) {
        if(prices == null || prices.Length == 0){
            return 0;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];

        for(int i = 0; i < k; i++){
            buy[i] = Int32.MaxValue;
        }

        for(int i = 0; i < prices.Length; i++){
            for(int j = 0; j< k; j++){
                if(j == 0){
                    buy[j] = Math.Min(buy[j], prices[i]);
                }
                else{
                    buy[j] = Math.Min(buy[j], prices[i] - sell[j-1]);
                }
                sell[j] = Math.Max(sell[j], prices[i] - buy[j]);
            }
        }

        return sell[k-1];
    }
}